package com.lzpeng.minimal.system.controller;


import com.lzpeng.minimal.common.core.response.Result;
import com.lzpeng.minimal.common.core.response.ResultUtil;
import com.lzpeng.minimal.system.domain.entity.Menu;
import com.lzpeng.minimal.system.domain.entity.Role;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Generated;
import java.util.List;

/**
 * 角色Controller
 *
 * @author: JpaCodeGenerator
 */
@Slf4j
@RestController
@RequestMapping("/system/role")
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-26 14:04:34", comments = "角色 控制层")
@Api(tags = "角色管理接口", value = "角色管理，提供角色的增、删、改、查")
public class RoleController extends AbstractRoleController {

    /**
     * 分配权限
     * @param id 角色id
     * @param permissions 权限id数组
     * @return 角色
     */
    @PostMapping(value = "/setPermissions/{id:^[a-zA-Z0-9]+_[a-zA-Z0-9]+_[a-zA-Z0-9]+$}")
    @ApiOperation("分配权限")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public Result<Role> setPermissions(@ApiParam("角色id") @PathVariable String id, @ApiParam("权限id数组") @RequestBody String[] permissions) {
        Role role = roleService.setPermissions(id, permissions);
        return ResultUtil.success(role);
    }

    /**
     * 获得角色的未拥有权限
     * @param id 角色id
     * @return 角色的未拥有权限
     */
    @GetMapping(value = "/noPermissions/{id:^[a-zA-Z0-9]+_[a-zA-Z0-9]+_[a-zA-Z0-9]+$}")
    @ApiOperation("得到角色未拥有权限")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public Result<List<Menu>> noPermissions(@ApiParam("角色id") @PathVariable String id) {
        List<Menu> menus = roleService.noPermissions(id);
        return ResultUtil.success(menus);
    }

}