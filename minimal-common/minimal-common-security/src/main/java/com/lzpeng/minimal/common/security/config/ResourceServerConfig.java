package com.lzpeng.minimal.common.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint;
import org.springframework.web.cors.CorsUtils;

/**
 * 资源服务器 配置
 * EnableConfigurationProperties 使 OAuth2Properties.class 配置生效
 * @author: Lzpeng
 */
@Configuration
@EnableResourceServer
@EnableConfigurationProperties(OAuth2Properties.class)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private OAuth2ExceptionTranslator oAuth2ExceptionTranslator;

    @Autowired
    private OAuth2Properties oAuth2Properties;

    private String[] urls = new String[] {"/druid/**", "/assets/**", "/actuator/**", "/doc.html/**", "/sys/user/login", "/webjars/**", "/swagger-ui.html/**", "/swagger-resources/**", "/v2/api-docs"};

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        super.configure(resources);
        // 定义异常转换类生效， 使用自己定义的OAuth2异常处理器
        OAuth2AuthenticationEntryPoint authenticationEntryPoint = new OAuth2AuthenticationEntryPoint();
        // 设置异常处理器
        authenticationEntryPoint.setExceptionTranslator(oAuth2ExceptionTranslator);
        resources.authenticationEntryPoint(authenticationEntryPoint);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests().antMatchers("/druid/**").permitAll();
        String[] customUrls = oAuth2Properties.getPermitAllUrls();
        String[] allUrls = new String[customUrls.length + urls.length];
        System.arraycopy(urls, 0, allUrls, 0, urls.length);
        System.arraycopy(customUrls, 0, allUrls, urls.length, customUrls.length);
        http
                .authorizeRequests()
                //对preflight放行
                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
                // 这些请求
                .mvcMatchers(allUrls)
                // 不需要身份认证
                .permitAll()
                .and()
                .authorizeRequests()
                //对preflight放行.permitAll()
                //.antMatchers("/sys/**").hasAnyRole("ADMIN")
                //其它所有请求
                .anyRequest()
                //需要身份认证
                .authenticated()
                // 取消iframe防御
                .and().headers().frameOptions().disable()
                .and().cors()
                //取消CSRF 防御
                .and().csrf().disable();
    }

}
