package com.lzpeng.minimal.common.api;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 公共API配置
 * @author : Lzpeng
 */

@Configuration
@EnableFeignClients
@ComponentScan(basePackageClasses = MinimalApiAutoConfiguration.class)
public class MinimalApiAutoConfiguration {
}
