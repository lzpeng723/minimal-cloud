package com.lzpeng.minimal.system.service;

import com.lzpeng.minimal.system.config.SpringSecurityAuditorAware;
import com.lzpeng.minimal.system.domain.entity.QUser;
import com.lzpeng.minimal.system.domain.entity.Role;
import com.lzpeng.minimal.system.domain.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Generated;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
* 用户 业务层
* @author: Lzpeng
*/
@Slf4j
@Service
@Transactional(rollbackOn = Exception.class)
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-25 2:02:06", comments = "用户 业务层")
public class UserService extends AbstractUserService implements UserDetailsService {
    /**
     * 密码加密和验证
     */
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 角色Service
     */
    @Autowired
    private RoleService roleService;

    /**
     * 获取 当前用户
     * junit 测试时 没有此Bean
     */
    @Autowired(required = false)
    private SpringSecurityAuditorAware auditorAware;

    /**
     * BCrypt 加密后的密码格式
     * @see org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder#BCRYPT_PATTERN
     */
    private Pattern BCRYPT_PATTERN = Pattern
            .compile("\\A\\$2(a|y|b)?\\$(\\d\\d)\\$[./0-9A-Za-z]{53}");

    /**
     * Spring Security 登录调用此方法
     * @param username 用户名
     * @return 用户
     * @throws UsernameNotFoundException 用户名未找到
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return findByUsername(username);
    }

    /**
     * 保存前对用户密码进行加密
     * @param user 用户
     * @return 是否保存此用户
     */
    @Override
    protected boolean beforeSave(User user) {
        String rawPassword = user.getPassword();
        if (StringUtils.isEmpty(rawPassword)) {
            // 默认密码 123456
            rawPassword = "123456";
        }
        // 去除首尾空格
        rawPassword = rawPassword.trim();
        if (!BCRYPT_PATTERN.matcher(rawPassword).matches()) {
            // 如果未加密过则进行加密
            String encodePassword = passwordEncoder.encode(rawPassword);
            user.setPassword(encodePassword);
        }
        return true;
    }

    /**
     * 分配角色
     * @param userId 用户id
     * @param roleIds 角色id数组
     * @return 分配角色完毕后的用户
     */
    public User setRoles(String userId, String[] roleIds) {
        User user = findById(userId);
        List<Role> roles = roleService.findAllById(Arrays.asList(roleIds));
        user.setRoles(roles);
        user = save(user);
        return user;
    }

    /**
     * 根据用户名查找用户
     * @param username 用户名
     * @return 用户
     */
    public User findByUsername(String username) {
        return userRepository.findOne(QUser.user.username.eq(username)).orElse(null);
    }

    /**
     * 用户注册
     * @return 注册成功的用户
     */
    public User register(User user){
        return save(user);
    }

    /**
     * 获得当前登录用户
     * @return 获得当前登录用户
     */
    public User getCurrentUser(){
        return auditorAware.getCurrentUser().orElse(null);
    }
}
