package com.lzpeng.minimal.common.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsUtils;

/**
 * Security 核心配置
 * @author: Lzpeng
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired(required = false)
    private UserDetailsService userDetailsService;


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    @ConditionalOnMissingBean(value = PasswordEncoder.class)
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    public void configure(HttpSecurity http) throws Exception {

        http
                .formLogin() // 表单登录 用户名密码登录
                .loginPage("/login.html")
                .loginProcessingUrl("/sys/user/login")
                .and()
                .authorizeRequests()
                //对preflight放行
                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
                // 这些请求
                .mvcMatchers("/assets/**", "/js/**", "/vendor/**", "/css/**", "/login.html", "/actuator/**", "/doc.html/**", "/ sys/user/login", "/webjars/**", "/swagger-ui.html/**", "/swagger-resources/**", "/v2/api-docs")
                // 不需要身份认证
                .permitAll()
                //其它所有请求
                .anyRequest()
                //需要身份认证
                .authenticated()
                .and().cors()
                //取消CSRF 防御
                .and().csrf().disable();
    }

    @Override
    public UserDetailsService userDetailsService() {
        return userDetailsService;
    }

}
