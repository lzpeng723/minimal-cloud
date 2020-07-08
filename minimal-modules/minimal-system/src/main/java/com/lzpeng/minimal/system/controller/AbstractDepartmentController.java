package com.lzpeng.minimal.system.controller;

import com.lzpeng.minimal.common.core.response.QueryResult;
import com.lzpeng.minimal.common.core.response.Result;
import com.lzpeng.minimal.common.core.domain.TableDictionary;
import com.lzpeng.minimal.common.jpa.controller.TreeController;
import com.lzpeng.minimal.common.jpa.domain.dto.BatchModel;
import com.lzpeng.minimal.system.domain.entity.Department;
import com.lzpeng.minimal.system.service.DepartmentService;
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
* 部门抽象控制器 提供增删改查接口
* @author: JpaCodeGenerator
*/
@Slf4j
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-27 12:42:04", comments = "抽象部门控制层,提供增删改查接口")
public class AbstractDepartmentController extends TreeController<Department> {

    /**
    * 模块名称
    */
    protected static final String MODULE_NAME = "system";
    /**
    * 部门实体类类名称
    */
    protected static final String CLASS_NAME = "department";
    /**
    * 部门列表权限
    */
    protected static final String LIST_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":list";
    /**
    * 部门查询权限
    */
    protected static final String QUERY_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":query";
    /**
    * 部门新增权限
    */
    protected static final String ADD_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":add";
    /**
    * 部门删除权限
    */
    protected static final String DELETE_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":delete";
    /**
    * 部门修改权限
    */
    protected static final String EDIT_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":edit";
    /**
    * 部门导出权限
    */
    protected static final String EXPORT_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":export";
    /**
    * 部门导入权限
    */
    protected static final String IMPORT_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":import";

    /**
    * 部门Service
    */
    protected DepartmentService departmentService;

    /**
    * IOC自动注入部门Service
    * @param departmentService 部门Service
    */
    @Autowired
    public void setDepartmentService(DepartmentService departmentService) {
        this.baseService = departmentService;
        this.treeService = departmentService;
        this.departmentService = departmentService;
    }

    /**
    * 获取部门的数据字典
    * @return 部门的数据字典
    */
    @Override
    @GetMapping("/dict")
    @ApiOperation("获取部门的数据字典")
    @PreAuthorize("hasAnyAuthority('" + LIST_PERM + "')")
    public Result<TableDictionary> getTableDictionary() {
        return super.getTableDictionary();
    }

    /**
    * 保存部门
    * @param model 部门数据
    * @return 保存之后的部门
    */
    @Override
    @PostMapping
    @ApiOperation("保存部门")
    @PreAuthorize("hasAnyAuthority('" + ADD_PERM + "')")
    public Result<Department> save(@Valid @RequestBody Department model) {
        return super.save(model);
    }

    /**
    * 删除部门
    * @param id 部门id
    * @return 是否删除成功
    */
    @Override
    @DeleteMapping("/{id:^[a-zA-Z0-9]+_[a-zA-Z0-9]+_[a-zA-Z0-9]+$}")
    @ApiOperation("删除部门")
    @PreAuthorize("hasAnyAuthority('" + DELETE_PERM + "')")
    public Result<Void> delete(@ApiParam(value = "主键id", required = true) @PathVariable("id") String id) {
        return super.delete(id);
    }


    /**
    * 根据 id 更新部门
    * @param id id 部门id
    * @param model 更新的部门
    * @return 更新后的结果
    */
    @Override
    @PutMapping("/{id:^[a-zA-Z0-9]+_[a-zA-Z0-9]+_[a-zA-Z0-9]+$}")
    @ApiOperation("更新部门")
    @PreAuthorize("hasAnyAuthority('" + EDIT_PERM + "')")
    public Result<Department> update(@ApiParam(value = "主键id", required = true) @PathVariable("id") String id, @RequestBody Department model) {
        return super.update(id, model);
    }

    /**
    * 查询所有部门
    * @param model JPA Example 查询条件
    * @return 查询结果
    */
    @Override
    @GetMapping
    @ApiOperation("查询所有部门")
    @PreAuthorize("hasAnyAuthority('" + QUERY_PERM + "')")
    public Result<List<Department>> findAll(Department model) {
        return super.findAll(model);
    }

    /**
    * 分页查询部门列表
    * @param page 页码
    * @param size 每页行数
    * @param model JPA Example 查询条件
    * @return 查询结果
    */
    @Override
    @GetMapping("/{page:[0-9]+}/{size:[0-9]+}")
    @ApiOperation("分页查询部门列表")
    @PreAuthorize("hasAnyAuthority('" + QUERY_PERM + "')")
    public Result<QueryResult<Department>> query(@ApiParam(value = "页码", required = true) @PathVariable("page") int page, @ApiParam(value = "每页数据条数", required = true) @PathVariable("size") int size, Department model) {
        return super.query(page, size, model);
    }

    /**
    * 根据ID查询部门
    * @param id 部门id
    * @return 部门
    */
    @Override
    @GetMapping("/{id:^[a-zA-Z0-9]+_[a-zA-Z0-9]+_[a-zA-Z0-9]+$}")
    @ApiOperation("根据ID查询部门")
    @PreAuthorize("hasAnyAuthority('" + QUERY_PERM + "')")
    public Result<Department> findById(@ApiParam(value = "主键id", required = true) @PathVariable("id") String id) {
        return super.findById(id);
    }

    /**
    * 从文件导入部门
    * @param file 上传的文件,支持 excel, json, xml
    * @return 导入成功的部门
    * @throws IOException 文件读写异常
    */
    @Override
    @PostMapping("/import")
    @ApiOperation("从文件导入部门")
    @PreAuthorize("hasAnyAuthority('" + IMPORT_PERM + "')")
    public Result<List<Department>> importData(MultipartFile file) throws IOException {
        return super.importData(file);
    }

    /**
    * 将在 ids 列表中的部门导出到 Excel
    * @param ids 部门id列表
    */
    @Override
    @GetMapping("/export")
    @ApiOperation("导出部门到文件")
    @PreAuthorize("permitAll()")
    public void exportData(@RequestParam(required = false) List<String> ids) throws IOException {
        super.exportData(ids);
    }

    /**
    * 批量操作部门
    * @param batch 批量操作参数
    * @return 操作结果
    */
    @Override
    @PostMapping("/batch")
    @ApiOperation("批量操作部门")
    @PreAuthorize("hasAuthority('" + ADD_PERM +"') and hasAuthority('" + EDIT_PERM +"') and hasAuthority('" + DELETE_PERM +"')")
    public Result batch(@RequestBody BatchModel<Department> batch) {
        return super.batch(batch);
    }

    /**
     * 获取树形结构的部门
     * @param model JPA Example 查询条件
     * @return 查询结果
     */
    @Override
    @GetMapping("/tree")
    @ApiOperation("获取树形结构的部门")
    @PreAuthorize("hasAnyAuthority('" + QUERY_PERM + "')")
    public Result<List<Department>> treeData(Department model) {
        return super.treeData(model);
    }


}