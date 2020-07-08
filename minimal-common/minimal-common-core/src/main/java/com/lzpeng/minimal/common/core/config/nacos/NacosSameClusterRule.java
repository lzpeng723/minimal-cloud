package com.lzpeng.minimal.common.core.config.nacos;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.ribbon.NacosServer;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.alibaba.nacos.client.naming.core.Balancer;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 扩展Ribbon 同一集群优先调用
 * @author: Lzpeng
 */
@Slf4j
public class NacosSameClusterRule extends AbstractLoadBalancerRule {

    @Autowired
    private NacosDiscoveryProperties nacosDiscoveryProperties;

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {

    }

    @Override
    public Server choose(Object key) {
        try {
            BaseLoadBalancer loadBalancer = (BaseLoadBalancer) this.getLoadBalancer();
            // 想要请求的微服务的名称
            String name = loadBalancer.getName();
            // 拿到服务发现的相关API
            NamingService namingService = nacosDiscoveryProperties.namingServiceInstance();
            // 拿到配置文件中的集群名称 BJ
            String clusterName = nacosDiscoveryProperties.getClusterName();
            // 1. 找到指定服务的所有实例 A
            List<Instance> instances = namingService.selectInstances(name, true);
            // 2. 过滤出相同集群下的所有实例 B
            List<Instance> sameClusterInstances = instances.stream()
                    .filter(instance -> Objects.equals(instance.getClusterName(), clusterName))
                    .collect(Collectors.toList());
            // 3. 如果B是空，就用A
            List<Instance> instancesToBeChosen;
            if (CollectionUtils.isEmpty(sameClusterInstances)) {
                instancesToBeChosen = instances;
                log.warn("发生跨集群的调用, name = {}, clusterName = {}, instances = {}",
                        name,
                        clusterName,
                        instances
                );
            } else {
                instancesToBeChosen = sameClusterInstances;
            }
            // 4. 基于权重的负载均衡算法，返回1个实例
            Instance instance = ExtendBalancer.getHostByRandomWeight2(instancesToBeChosen);
            log.info("选择的实例是 port = {}, instance = {}", instance.getPort(), instance);

            return new NacosServer(instance);
        } catch (NacosException e) {
            log.error("发生异常了", e);
            return null;
        }
    }
}

class ExtendBalancer extends Balancer {
    /**
     * @see NamingService#selectOneHealthyInstance(String)
     * @param hosts 实例列表
     * @return 根据Nacos权重返回应该调用的实例
     */
    public static Instance getHostByRandomWeight2(List<Instance> hosts) {
        return getHostByRandomWeight(hosts);
    }
}