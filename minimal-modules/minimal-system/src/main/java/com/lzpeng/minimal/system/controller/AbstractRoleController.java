package com.lzpeng.minimal.system.controller;

import com.lzpeng.minimal.common.core.response.QueryResult;
import com.lzpeng.minimal.common.core.response.Result;
import com.lzpeng.minimal.common.core.domain.TableDictionary;
import com.lzpeng.minimal.common.jpa.controller.LeftTreeRightTableController;
import com.lzpeng.minimal.common.jpa.domain.dto.BatchModel;
import com.lzpeng.minimal.system.domain.entity.Role;
import com.lzpeng.minimal.system.service.RoleService;
import com.lzpeng.minimal.system.domain.entity.Department;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Generated;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
* 角色抽象控制器 提供增删改查接口
* @author: JpaCodeGenerator
*/
@Slf4j
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-27 12:42:04", comments = "抽象角色控制层,提供增删改查接口")
public class AbstractRoleController extends LeftTreeRightTableController<Department, Role> {

    /**
    * 模块名称
    */
    protected static final String MODULE_NAME = "system";
    /**
    * 角色实体类类名称
    */
    protected static final String CLASS_NAME = "role";
    /**
    * 角色列表权限
    */
    protected static final String LIST_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":list";
    /**
    * 角色查询权限
    */
    protected static final String QUERY_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":query";
    /**
    * 角色新增权限
    */
    protected static final String ADD_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":add";
    /**
    * 角色删除权限
    */
    protected static final String DELETE_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":delete";
    /**
    * 角色修改权限
    */
    protected static final String EDIT_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":edit";
    /**
    * 角色导出权限
    */
    protected static final String EXPORT_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":export";
    /**
    * 角色导入权限
    */
    protected static final String IMPORT_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":import";

    /**
    * 角色Service
    */
    protected RoleService roleService;

    /**
    * IOC自动注入角色Service
    * @param roleService 角色Service
    */
    @Autowired
    public void setRoleService(RoleService roleService) {
        this.baseService = roleService;
        this.leftTreeRightTableService = roleService;
        this.roleService = roleService;
    }

    /**
    * 获取角色的数据字典
    * @return 角色的数据字典
    */
    @Override
    @GetMapping("/dict")
    @ApiOperation("获取角色的数据字典")
    @PreAuthorize("hasAnyAuthority('" + LIST_PERM + "')")
    public Result<TableDictionary> getTableDictionary() {
        return super.getTableDictionary();
    }

    /**
    * 保存角色
    * @param model 角色数据
    * @return 保存之后的角色
    */
    @Override
    @PostMapping
    @ApiOperation("保存角色")
    @PreAuthorize("hasAnyAuthority('" + ADD_PERM + "')")
    public Result<Role> save(@Valid @RequestBody Role model) {
        return super.save(model);
    }

    /**
    * 删除角色
    * @param id 角色id
    * @return 是否删除成功
    */
    @Override
    @DeleteMapping("/{id:^[a-zA-Z0-9]+_[a-zA-Z0-9]+_[a-zA-Z0-9]+$}")
    @ApiOperation("删除角色")
    @PreAuthorize("hasAnyAuthority('" + DELETE_PERM + "')")
    public Result<Void> delete(@ApiParam(value = "主键id", required = true) @PathVariable("id") String id) {
        return super.delete(id);
    }


    /**
    * 根据 id 更新角色
    * @param id id 角色id
    * @param model 更新的角色
    * @return 更新后的结果
    */
    @Override
    @PutMapping("/{id:^[a-zA-Z0-9]+_[a-zA-Z0-9]+_[a-zA-Z0-9]+$}")
    @ApiOperation("更新角色")
    @PreAuthorize("hasAnyAuthority('" + EDIT_PERM + "')")
    public Result<Role> update(@ApiParam(value = "主键id", required = true) @PathVariable("id") String id, @RequestBody Role model) {
        return super.update(id, model);
    }

    /**
    * 查询所有角色
    * @param model JPA Example 查询条件
    * @return 查询结果
    */
    @Override
    @GetMapping
    @ApiOperation("查询所有角色")
    @PreAuthorize("hasAnyAuthority('" + QUERY_PERM + "')")
    public Result<List<Role>> findAll(Role model) {
        return super.findAll(model);
    }

    /**
    * 分页查询角色列表
    * @param page 页码
    * @param size 每页行数
    * @param model JPA Example 查询条件
    * @return 查询结果
    */
    @Override
    @GetMapping("/{page:[0-9]+}/{size:[0-9]+}")
    @ApiOperation("分页查询角色列表")
    @PreAuthorize("hasAnyAuthority('" + QUERY_PERM + "')")
    public Result<QueryResult<Role>> query(@ApiParam(value = "页码", required = true) @PathVariable("page") int page, @ApiParam(value = "每页数据条数", required = true) @PathVariable("size") int size, Role model) {
        return super.query(page, size, model);
    }

    /**
    * 根据ID查询角色
    * @param id 角色id
    * @return 角色
    */
    @Override
    @GetMapping("/{id:^[a-zA-Z0-9]+_[a-zA-Z0-9]+_[a-zA-Z0-9]+$}")
    @ApiOperation("根据ID查询角色")
    @PreAuthorize("hasAnyAuthority('" + QUERY_PERM + "')")
    public Result<Role> findById(@ApiParam(value = "主键id", required = true) @PathVariable("id") String id) {
        return super.findById(id);
    }

    /**
    * 从文件导入角色
    * @param file 上传的文件,支持 excel, json, xml
    * @return 导入成功的角色
    * @throws IOException 文件读写异常
    */
    @Override
    @PostMapping("/import")
    @ApiOperation("从文件导入角色")
    @PreAuthorize("hasAnyAuthority('" + IMPORT_PERM + "')")
    public Result<List<Role>> importData(MultipartFile file) throws IOException {
        return super.importData(file);
    }

    /**
    * 将在 ids 列表中的角色导出到 Excel
    * @param ids 角色id列表
    */
    @Override
    @GetMapping("/export")
    @ApiOperation("导出角色到文件")
    @PreAuthorize("permitAll()")
    public void exportData(@RequestParam(required = false) List<String> ids) throws IOException {
        super.exportData(ids);
    }

    /**
    * 批量操作角色
    * @param batch 批量操作参数
    * @return 操作结果
    */
    @Override
    @PostMapping("/batch")
    @ApiOperation("批量操作角色")
    @PreAuthorize("hasAuthority('" + ADD_PERM +"') and hasAuthority('" + EDIT_PERM +"') and hasAuthority('" + DELETE_PERM +"')")
    public Result batch(@RequestBody BatchModel<Role> batch) {
        return super.batch(batch);
    }


    /**
    * 获取左树数据
    * @return 左树数据
    */
    @Override
    @GetMapping("/leftTree")
    @ApiOperation("获取左树数据")
    @PreAuthorize("hasAnyAuthority('" + QUERY_PERM + "')")
    public Result<List<Department>> leftTreeData() {
        return super.leftTreeData();
    }

}