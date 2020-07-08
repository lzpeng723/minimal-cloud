package com.lzpeng.minimal.gateway;

import com.lzpeng.minimal.common.api.feign.ToolRemoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractNameValueGatewayFilterFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

/**
 * 自定义过滤器,记录日志
 * 必须以 GatewayFilterFactory 结尾
 * @author: Lzpeng
 */
@Slf4j
@Component
public class PreLogGatewayFilterFactory extends AbstractNameValueGatewayFilterFactory {

    @Lazy
    @Autowired
    private ToolRemoteService toolRemoteService;

    @Override
    public GatewayFilter apply(NameValueConfig config) {

        return (exchange, chain) -> {
            log.info("请求进来了... {}:{}", config.getName(), config.getValue());
            toolRemoteService.saveRequestLog(null);
            ServerHttpRequest httpRequest = exchange.getRequest().mutate()
                    .header("Foo", "Bar")
                    .build();
            ServerWebExchange modifyExchange = exchange.mutate()
                    .request(httpRequest)
                    .build();
            return chain.filter(modifyExchange);

        };
    }
}
