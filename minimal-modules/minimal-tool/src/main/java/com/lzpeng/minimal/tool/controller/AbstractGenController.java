package com.lzpeng.minimal.tool.controller;

import com.lzpeng.minimal.common.core.response.QueryResult;
import com.lzpeng.minimal.common.core.response.Result;
import com.lzpeng.minimal.common.core.domain.TableDictionary;
import com.lzpeng.minimal.common.jpa.domain.dto.BatchModel;
import com.lzpeng.minimal.common.jpa.controller.BaseController;
import com.lzpeng.minimal.tool.domain.entity.Gen;
import com.lzpeng.minimal.tool.service.GenService;
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
* 代码生成模板抽象控制器 提供增删改查接口
* @author: JpaCodeGenerator
*/
@Slf4j
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-27 23:21:56", comments = "抽象代码生成模板控制层,提供增删改查接口")
public class AbstractGenController extends BaseController<Gen> {

    /**
    * 模块名称
    */
    protected static final String MODULE_NAME = "tool";
    /**
    * 代码生成模板实体类类名称
    */
    protected static final String CLASS_NAME = "gen";
    /**
    * 代码生成模板列表权限
    */
    protected static final String LIST_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":list";
    /**
    * 代码生成模板查询权限
    */
    protected static final String QUERY_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":query";
    /**
    * 代码生成模板新增权限
    */
    protected static final String ADD_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":add";
    /**
    * 代码生成模板删除权限
    */
    protected static final String DELETE_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":delete";
    /**
    * 代码生成模板修改权限
    */
    protected static final String EDIT_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":edit";
    /**
    * 代码生成模板导出权限
    */
    protected static final String EXPORT_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":export";
    /**
    * 代码生成模板导入权限
    */
    protected static final String IMPORT_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":import";

    /**
    * 代码生成模板Service
    */
    protected GenService genService;

    /**
    * IOC自动注入代码生成模板Service
    * @param genService 代码生成模板Service
    */
    @Autowired
    public void setGenService(GenService genService) {
        this.baseService = genService;
        this.baseService = genService;
        this.genService = genService;
    }

    /**
    * 获取代码生成模板的数据字典
    * @return 代码生成模板的数据字典
    */
    @Override
    @GetMapping("/dict")
    @ApiOperation("获取代码生成模板的数据字典")
    @PreAuthorize("hasAnyAuthority('" + LIST_PERM + "')")
    public Result<TableDictionary> getTableDictionary() {
        return super.getTableDictionary();
    }

    /**
    * 保存代码生成模板
    * @param model 代码生成模板数据
    * @return 保存之后的代码生成模板
    */
    @Override
    @PostMapping
    @ApiOperation("保存代码生成模板")
    @PreAuthorize("hasAnyAuthority('" + ADD_PERM + "')")
    public Result<Gen> save(@Valid @RequestBody Gen model) {
        return super.save(model);
    }

    /**
    * 删除代码生成模板
    * @param id 代码生成模板id
    * @return 是否删除成功
    */
    @Override
    @DeleteMapping("/{id:^[a-zA-Z0-9]+_[a-zA-Z0-9]+_[a-zA-Z0-9]+$}")
    @ApiOperation("删除代码生成模板")
    @PreAuthorize("hasAnyAuthority('" + DELETE_PERM + "')")
    public Result<Void> delete(@ApiParam(value = "主键id", required = true) @PathVariable("id") String id) {
        return super.delete(id);
    }


    /**
    * 根据 id 更新代码生成模板
    * @param id id 代码生成模板id
    * @param model 更新的代码生成模板
    * @return 更新后的结果
    */
    @Override
    @PutMapping("/{id:^[a-zA-Z0-9]+_[a-zA-Z0-9]+_[a-zA-Z0-9]+$}")
    @ApiOperation("更新代码生成模板")
    @PreAuthorize("hasAnyAuthority('" + EDIT_PERM + "')")
    public Result<Gen> update(@ApiParam(value = "主键id", required = true) @PathVariable("id") String id, @RequestBody Gen model) {
        return super.update(id, model);
    }

    /**
    * 查询所有代码生成模板
    * @param model JPA Example 查询条件
    * @return 查询结果
    */
    @Override
    @GetMapping
    @ApiOperation("查询所有代码生成模板")
    @PreAuthorize("hasAnyAuthority('" + QUERY_PERM + "')")
    public Result<List<Gen>> findAll(Gen model) {
        return super.findAll(model);
    }

    /**
    * 分页查询代码生成模板列表
    * @param page 页码
    * @param size 每页行数
    * @param model JPA Example 查询条件
    * @return 查询结果
    */
    @Override
    @GetMapping("/{page:[0-9]+}/{size:[0-9]+}")
    @ApiOperation("分页查询代码生成模板列表")
    @PreAuthorize("hasAnyAuthority('" + QUERY_PERM + "')")
    public Result<QueryResult<Gen>> query(@ApiParam(value = "页码", required = true) @PathVariable("page") int page, @ApiParam(value = "每页数据条数", required = true) @PathVariable("size") int size, Gen model) {
        return super.query(page, size, model);
    }

    /**
    * 根据ID查询代码生成模板
    * @param id 代码生成模板id
    * @return 代码生成模板
    */
    @Override
    @GetMapping("/{id:^[a-zA-Z0-9]+_[a-zA-Z0-9]+_[a-zA-Z0-9]+$}")
    @ApiOperation("根据ID查询代码生成模板")
    @PreAuthorize("hasAnyAuthority('" + QUERY_PERM + "')")
    public Result<Gen> findById(@ApiParam(value = "主键id", required = true) @PathVariable("id") String id) {
        return super.findById(id);
    }

    /**
    * 从文件导入代码生成模板
    * @param file 上传的文件,支持 excel, json, xml
    * @return 导入成功的代码生成模板
    * @throws IOException 文件读写异常
    */
    @Override
    @PostMapping("/import")
    @ApiOperation("从文件导入代码生成模板")
    @PreAuthorize("hasAnyAuthority('" + IMPORT_PERM + "')")
    public Result<List<Gen>> importData(MultipartFile file) throws IOException {
        return super.importData(file);
    }

    /**
    * 将在 ids 列表中的代码生成模板导出到 Excel
    * @param ids 代码生成模板id列表
    */
    @Override
    @GetMapping("/export")
    @ApiOperation("导出代码生成模板到文件")
    @PreAuthorize("permitAll()")
    public void exportData(@RequestParam(required = false) List<String> ids) throws IOException {
        super.exportData(ids);
    }

    /**
    * 批量操作代码生成模板
    * @param batch 批量操作参数
    * @return 操作结果
    */
    @Override
    @PostMapping("/batch")
    @ApiOperation("批量操作代码生成模板")
    @PreAuthorize("hasAuthority('" + ADD_PERM +"') and hasAuthority('" + EDIT_PERM +"') and hasAuthority('" + DELETE_PERM +"')")
    public Result batch(@RequestBody BatchModel<Gen> batch) {
        return super.batch(batch);
    }



}