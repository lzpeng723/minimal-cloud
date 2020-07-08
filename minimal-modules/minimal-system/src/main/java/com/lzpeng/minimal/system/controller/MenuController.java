package com.lzpeng.minimal.system.controller;


import com.lzpeng.minimal.common.core.response.Result;
import com.lzpeng.minimal.common.core.response.ResultUtil;
import com.lzpeng.minimal.system.domain.entity.Menu;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Generated;
import java.util.List;

/**
* 权限菜单Controller
* @author: JpaCodeGenerator
*/
@Slf4j
@RestController
@RequestMapping("/system/menu")
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-26 14:04:34", comments = "权限菜单 控制层")
@Api(tags = "权限菜单管理接口", value = "权限菜单管理，提供权限菜单的增、删、改、查")
public class MenuController extends AbstractMenuController {


    @GetMapping("/routers")
    @ApiOperation("获取用户路由菜单")
    @PreAuthorize("isAuthenticated()")
    public Result<List<Menu>> getRouters() {
        List<Menu> routers = menuService.getRouters();
        return ResultUtil.success(routers);
    }

    @GetMapping("/allRouters")
    @ApiOperation("获取所有路由菜单")
    @PreAuthorize("isAuthenticated()")
    public Result<List<Menu>> getAllRouters() {
        List<Menu> routers = menuService.getAllRouters();
        return ResultUtil.success(routers);
    }

}