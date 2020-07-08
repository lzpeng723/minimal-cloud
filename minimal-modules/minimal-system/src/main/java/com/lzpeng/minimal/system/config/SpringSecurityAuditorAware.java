package com.lzpeng.minimal.system.config;

import com.lzpeng.minimal.system.domain.entity.User;
import com.lzpeng.minimal.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * 获取当前登录用户 Id
 * @author : Lzpeng
 */
@Component
@ConditionalOnMissingClass("org.junit.jupiter.api.Test")
public class SpringSecurityAuditorAware implements AuditorAware<String> {

    @Autowired
    private UserService userService;


    /**
     * 获得当前登录用户ID
     * @return 当前登录用户ID
     */
    @Override
    public Optional<String> getCurrentAuditor() {
        return getCurrentUser().map(User::getId);
    }

    /**
     * 获取当前登录用户
     * @return 当前登录用户
     */
    public Optional<User> getCurrentUser() {
        User user = ThreadLocals.USER.get();
        if (user != null) {
            return Optional.ofNullable(user);
        }
        // 获取当前登录用户
        Object principal = Optional.ofNullable(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication)
                .filter(Authentication::isAuthenticated)
                .map(Authentication::getPrincipal)
                .orElse(null);
        if (principal instanceof User) {
            // 模拟 Spring Security 登录
            return Optional.ofNullable((User)principal);
        }
        if (principal instanceof String) {
            // OAuth2 登录
            user = userService.findByUsername((String) principal);
            // 懒加载不序列化到前台,收到加载一下角色
            user.setRoles(user.getRoles());
            ThreadLocals.USER.set(user);
            return Optional.ofNullable(user);
        }
        return Optional.empty();
    }
}
