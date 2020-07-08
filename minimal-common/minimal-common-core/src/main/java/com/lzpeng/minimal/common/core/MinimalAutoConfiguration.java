package com.lzpeng.minimal.common.core;

import cn.hutool.extra.spring.SpringUtil;
import com.lzpeng.minimal.common.core.util.EnvUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.Banner;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.Ordered;
import org.springframework.core.SpringVersion;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.lang.Nullable;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author: Lzpeng
 */
@Slf4j
@EnableAsync
@EnableCaching
@EnableScheduling
@EnableFeignClients
@EnableCircuitBreaker
@EnableDiscoveryClient
@ComponentScan(basePackageClasses = MinimalAutoConfiguration.class)
public final class MinimalAutoConfiguration {

    /**
     * 启动完成打印 Banner 信息
     * @return 打印 Banner 信息的 Bean
     */
    @Bean
    public ApplicationRunner printBanner() {
        return args -> {
            Environment environment = SpringUtil.getBean(Environment.class);
            Banner banner = SpringUtil.getBean(Banner.class);
            banner.printBanner(environment, SpringVersion.class, System.out);
            String appName = environment.getProperty("spring.application.name", String.class, "minimal");
            int port = environment.getProperty("server.port", int.class, 8080);
            log.info("{} 在 {} 端口启动成功", appName, port);
            log.info("当前环境是 {}", EnvUtil.isDev() ? "开发环境" : "正式环境");
        };
    }
}
