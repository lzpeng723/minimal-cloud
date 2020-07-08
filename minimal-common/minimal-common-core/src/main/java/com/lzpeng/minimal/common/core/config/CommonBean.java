package com.lzpeng.minimal.common.core.config;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Enumeration;

/**
 * @author: Lzpeng
 */
@Configuration
public class CommonBean {

    @Bean
    @ConditionalOnMissingBean
    public Snowflake snowflake() {
        return IdUtil.getSnowflake(0,0);
    }

    /**
     * LoadBalanced: 启用负载均衡
     * SentinelRestTemplate: 启用Sentinel限流熔断
     * @return 默认的 RestTemplate
     * @see com.alibaba.cloud.sentinel.custom.SentinelBeanPostProcessor
     */
    @Bean
    @LoadBalanced
    @SentinelRestTemplate
    @ConditionalOnMissingBean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        // RestTemplate 拦截器
        restTemplate.setInterceptors(Collections.singletonList(relayHeaderClientHttpRequestInterceptor()));
        return restTemplate;
    }

    @Bean
    public ClientHttpRequestInterceptor relayHeaderClientHttpRequestInterceptor(){
        return (request, body, execution) -> {
            // 获取 Request
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            ServletRequestAttributes attributes = (ServletRequestAttributes) requestAttributes;
            assert attributes != null;
            HttpServletRequest httpServletRequest = attributes.getRequest();
            // 传递请求头参数, Authorization: Token
            Enumeration<String> headerNames = httpServletRequest.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                request.getHeaders().add(headerName, httpServletRequest.getHeader(headerName));
            }
            return execution.execute(request, body);
        };
    }

}
