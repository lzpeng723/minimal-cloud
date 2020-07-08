package com.lzpeng.minimal.system.initdata;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

/**
 * 模拟用户登录
 * @author: 李志鹏
 */
@Slf4j
@Component
@Order(Ordered.HIGHEST_PRECEDENCE + 1)
@ConditionalOnWebApplication
@ConditionalOnMissingClass("org.junit.jupiter.api.Test")
public class MockLoginInitialize  implements ApplicationRunner {

    /**
     * Spring Security 认证管理器
     */
    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * 模拟登录用户
     * SpringBoot jpa 使用懒加载时，报异常：session失效
     * spring.jpa.open-in-view: true
     * @see javax.transaction.Transactional
     * @see org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter
     * @param args 程序启动参数
     */
    @Override
    @Transactional(rollbackOn = Exception.class)
    public void run(ApplicationArguments args) {
        UsernamePasswordAuthenticationToken administrator = new UsernamePasswordAuthenticationToken("administrator", "mcadmin");
        // 登录用户
        Authentication authentication = authenticationManager.authenticate(administrator);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
