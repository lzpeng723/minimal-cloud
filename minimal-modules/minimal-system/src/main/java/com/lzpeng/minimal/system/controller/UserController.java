package com.lzpeng.minimal.system.controller;


import com.lzpeng.minimal.common.core.response.Result;
import com.lzpeng.minimal.common.core.response.ResultUtil;
import com.lzpeng.minimal.system.domain.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Generated;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

/**
* 用户Controller
* @author: JpaCodeGenerator
*/
@Slf4j
@RestController
@RequestMapping("/system/user")
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-26 14:04:34", comments = "用户控制层")
@Api(tags = "用户管理接口", value = "用户管理，提供用户的增、删、改、查")
public class UserController extends AbstractUserController {

    /**
     * 用户注册
     * @param model 用户信息
     * @return 注册成功的用户
     */
    @PostMapping("/register")
    @ApiOperation("用户注册")
    public Result<User> register(@Valid @RequestBody User model){
        User user = userService.register(model);
        return ResultUtil.success(user);
    }

    /**
     * 获取当前登录用户
     * @param userDetails 当前登录用户
     * @return 当前登录用户
     */
    @GetMapping("/me")
    @ApiOperation("我的信息")
    @PreAuthorize("isAuthenticated()")
    public User getCurrentUser(){
        return userService.getCurrentUser();
    }

    /**
     * 分配角色
     * @param id 用户id
     * @param roles 角色id列表
     * @return 分配完成后的用户
     */
    @PostMapping(value = "/setRoles/{id:^[a-zA-Z0-9]+_[a-zA-Z0-9]+_[a-zA-Z0-9]+$}")
    @ApiOperation("分配角色")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public Result<User> setRoles(@ApiParam("用户id") @PathVariable String id, @ApiParam("角色id数组") @RequestBody String[] roles) {
        User user = userService.setRoles(id, roles);
        return ResultUtil.success(user);
    }

    /**
     * 判断当前用户是否拥有权限
     * @param permissions 权限编码列表
     * @return 是否拥有权限
     */
    @PostMapping(value = "/hasPermissions")
    @ApiOperation("判断是否有权限")
    @PreAuthorize("isAuthenticated()")
    public Result<String> hasPermissions(@ApiParam("权限编码数组") @RequestBody String[] permissions) {
        Collection<? extends GrantedAuthority> authorities = userService.getCurrentUser().getAuthorities();
        Set<String> authoritySet = authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet());
        boolean hasPerm = authoritySet.containsAll(Arrays.asList(permissions));
        return hasPerm ? ResultUtil.success() : ResultUtil.fail("没有对应权限");
    }

}