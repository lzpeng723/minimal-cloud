package com.lzpeng.minimal.common.security;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author: Lzpeng
 */
@ComponentScan(basePackageClasses = SecurityAutoConfiguration.class)
public class SecurityAutoConfiguration {

    /**
     * 启动完成退出登录
     * @return 退出登录的 Bean
     */
    @Bean
    @Order(Ordered.LOWEST_PRECEDENCE - 1)
    public ApplicationRunner printBanner() {
        return args -> {
            SecurityContextHolder.getContext().setAuthentication(null);
        };
    }

}
