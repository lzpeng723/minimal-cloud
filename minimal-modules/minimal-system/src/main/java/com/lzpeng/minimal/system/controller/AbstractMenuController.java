package com.lzpeng.minimal.system.controller;

import com.lzpeng.minimal.common.core.response.QueryResult;
import com.lzpeng.minimal.common.core.response.Result;
import com.lzpeng.minimal.common.core.domain.TableDictionary;
import com.lzpeng.minimal.common.jpa.controller.TreeController;
import com.lzpeng.minimal.common.jpa.domain.dto.BatchModel;
import com.lzpeng.minimal.system.domain.entity.Menu;
import com.lzpeng.minimal.system.service.MenuService;
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
* 权限菜单抽象控制器 提供增删改查接口
* @author: JpaCodeGenerator
*/
@Slf4j
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-27 12:42:04", comments = "抽象权限菜单控制层,提供增删改查接口")
public class AbstractMenuController extends TreeController<Menu> {

    /**
    * 模块名称
    */
    protected static final String MODULE_NAME = "system";
    /**
    * 权限菜单实体类类名称
    */
    protected static final String CLASS_NAME = "menu";
    /**
    * 权限菜单列表权限
    */
    protected static final String LIST_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":list";
    /**
    * 权限菜单查询权限
    */
    protected static final String QUERY_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":query";
    /**
    * 权限菜单新增权限
    */
    protected static final String ADD_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":add";
    /**
    * 权限菜单删除权限
    */
    protected static final String DELETE_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":delete";
    /**
    * 权限菜单修改权限
    */
    protected static final String EDIT_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":edit";
    /**
    * 权限菜单导出权限
    */
    protected static final String EXPORT_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":export";
    /**
    * 权限菜单导入权限
    */
    protected static final String IMPORT_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":import";

    /**
    * 权限菜单Service
    */
    protected MenuService menuService;

    /**
    * IOC自动注入权限菜单Service
    * @param menuService 权限菜单Service
    */
    @Autowired
    public void setMenuService(MenuService menuService) {
        this.baseService = menuService;
        this.treeService = menuService;
        this.menuService = menuService;
    }

    /**
    * 获取权限菜单的数据字典
    * @return 权限菜单的数据字典
    */
    @Override
    @GetMapping("/dict")
    @ApiOperation("获取权限菜单的数据字典")
    @PreAuthorize("hasAnyAuthority('" + LIST_PERM + "')")
    public Result<TableDictionary> getTableDictionary() {
        return super.getTableDictionary();
    }

    /**
    * 保存权限菜单
    * @param model 权限菜单数据
    * @return 保存之后的权限菜单
    */
    @Override
    @PostMapping
    @ApiOperation("保存权限菜单")
    @PreAuthorize("hasAnyAuthority('" + ADD_PERM + "')")
    public Result<Menu> save(@Valid @RequestBody Menu model) {
        return super.save(model);
    }

    /**
    * 删除权限菜单
    * @param id 权限菜单id
    * @return 是否删除成功
    */
    @Override
    @DeleteMapping("/{id:^[a-zA-Z0-9]+_[a-zA-Z0-9]+_[a-zA-Z0-9]+$}")
    @ApiOperation("删除权限菜单")
    @PreAuthorize("hasAnyAuthority('" + DELETE_PERM + "')")
    public Result<Void> delete(@ApiParam(value = "主键id", required = true) @PathVariable("id") String id) {
        return super.delete(id);
    }


    /**
    * 根据 id 更新权限菜单
    * @param id id 权限菜单id
    * @param model 更新的权限菜单
    * @return 更新后的结果
    */
    @Override
    @PutMapping("/{id:^[a-zA-Z0-9]+_[a-zA-Z0-9]+_[a-zA-Z0-9]+$}")
    @ApiOperation("更新权限菜单")
    @PreAuthorize("hasAnyAuthority('" + EDIT_PERM + "')")
    public Result<Menu> update(@ApiParam(value = "主键id", required = true) @PathVariable("id") String id, @RequestBody Menu model) {
        return super.update(id, model);
    }

    /**
    * 查询所有权限菜单
    * @param model JPA Example 查询条件
    * @return 查询结果
    */
    @Override
    @GetMapping
    @ApiOperation("查询所有权限菜单")
    @PreAuthorize("hasAnyAuthority('" + QUERY_PERM + "')")
    public Result<List<Menu>> findAll(Menu model) {
        return super.findAll(model);
    }

    /**
    * 分页查询权限菜单列表
    * @param page 页码
    * @param size 每页行数
    * @param model JPA Example 查询条件
    * @return 查询结果
    */
    @Override
    @GetMapping("/{page:[0-9]+}/{size:[0-9]+}")
    @ApiOperation("分页查询权限菜单列表")
    @PreAuthorize("hasAnyAuthority('" + QUERY_PERM + "')")
    public Result<QueryResult<Menu>> query(@ApiParam(value = "页码", required = true) @PathVariable("page") int page, @ApiParam(value = "每页数据条数", required = true) @PathVariable("size") int size, Menu model) {
        return super.query(page, size, model);
    }

    /**
    * 根据ID查询权限菜单
    * @param id 权限菜单id
    * @return 权限菜单
    */
    @Override
    @GetMapping("/{id:^[a-zA-Z0-9]+_[a-zA-Z0-9]+_[a-zA-Z0-9]+$}")
    @ApiOperation("根据ID查询权限菜单")
    @PreAuthorize("hasAnyAuthority('" + QUERY_PERM + "')")
    public Result<Menu> findById(@ApiParam(value = "主键id", required = true) @PathVariable("id") String id) {
        return super.findById(id);
    }

    /**
    * 从文件导入权限菜单
    * @param file 上传的文件,支持 excel, json, xml
    * @return 导入成功的权限菜单
    * @throws IOException 文件读写异常
    */
    @Override
    @PostMapping("/import")
    @ApiOperation("从文件导入权限菜单")
    @PreAuthorize("hasAnyAuthority('" + IMPORT_PERM + "')")
    public Result<List<Menu>> importData(MultipartFile file) throws IOException {
        return super.importData(file);
    }

    /**
    * 将在 ids 列表中的权限菜单导出到 Excel
    * @param ids 权限菜单id列表
    */
    @Override
    @GetMapping("/export")
    @ApiOperation("导出权限菜单到文件")
    @PreAuthorize("permitAll()")
    public void exportData(@RequestParam(required = false) List<String> ids) throws IOException {
        super.exportData(ids);
    }

    /**
    * 批量操作权限菜单
    * @param batch 批量操作参数
    * @return 操作结果
    */
    @Override
    @PostMapping("/batch")
    @ApiOperation("批量操作权限菜单")
    @PreAuthorize("hasAuthority('" + ADD_PERM +"') and hasAuthority('" + EDIT_PERM +"') and hasAuthority('" + DELETE_PERM +"')")
    public Result batch(@RequestBody BatchModel<Menu> batch) {
        return super.batch(batch);
    }

    /**
     * 获取树形结构的权限菜单
     * @param model JPA Example 查询条件
     * @return 查询结果
     */
    @Override
    @GetMapping("/tree")
    @ApiOperation("获取树形结构的权限菜单")
    @PreAuthorize("hasAnyAuthority('" + QUERY_PERM + "')")
    public Result<List<Menu>> treeData(Menu model) {
        return super.treeData(model);
    }


}