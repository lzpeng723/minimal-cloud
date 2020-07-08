package com.lzpeng.minimal.samplejpa.controller;

import com.lzpeng.minimal.common.core.response.QueryResult;
import com.lzpeng.minimal.common.core.response.Result;
import com.lzpeng.minimal.common.core.domain.TableDictionary;
import com.lzpeng.minimal.common.jpa.domain.dto.BatchModel;
import com.lzpeng.minimal.common.jpa.controller.BaseController;
import com.lzpeng.minimal.samplejpa.domain.entity.SampleEntity;
import com.lzpeng.minimal.samplejpa.service.SampleEntityService;
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
* 示例实体抽象控制器 提供增删改查接口
* @author: JpaCodeGenerator
*/
@Slf4j
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-28 20:50:57", comments = "抽象示例实体控制层,提供增删改查接口")
public class AbstractSampleEntityController extends BaseController<SampleEntity> {

    /**
    * 模块名称
    */
    protected static final String MODULE_NAME = "samplejpa";
    /**
    * 示例实体实体类类名称
    */
    protected static final String CLASS_NAME = "sampleEntity";
    /**
    * 示例实体列表权限
    */
    protected static final String LIST_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":list";
    /**
    * 示例实体查询权限
    */
    protected static final String QUERY_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":query";
    /**
    * 示例实体新增权限
    */
    protected static final String ADD_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":add";
    /**
    * 示例实体删除权限
    */
    protected static final String DELETE_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":delete";
    /**
    * 示例实体修改权限
    */
    protected static final String EDIT_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":edit";
    /**
    * 示例实体导出权限
    */
    protected static final String EXPORT_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":export";
    /**
    * 示例实体导入权限
    */
    protected static final String IMPORT_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":import";

    /**
    * 示例实体Service
    */
    protected SampleEntityService sampleEntityService;

    /**
    * IOC自动注入示例实体Service
    * @param sampleEntityService 示例实体Service
    */
    @Autowired
    public void setSampleEntityService(SampleEntityService sampleEntityService) {
        this.baseService = sampleEntityService;
        this.baseService = sampleEntityService;
        this.sampleEntityService = sampleEntityService;
    }

    /**
    * 获取示例实体的数据字典
    * @return 示例实体的数据字典
    */
    @Override
    @GetMapping("/dict")
    @ApiOperation("获取示例实体的数据字典")
    @PreAuthorize("hasAnyAuthority('" + LIST_PERM + "')")
    public Result<TableDictionary> getTableDictionary() {
        return super.getTableDictionary();
    }

    /**
    * 保存示例实体
    * @param model 示例实体数据
    * @return 保存之后的示例实体
    */
    @Override
    @PostMapping
    @ApiOperation("保存示例实体")
    @PreAuthorize("hasAnyAuthority('" + ADD_PERM + "')")
    public Result<SampleEntity> save(@Valid @RequestBody SampleEntity model) {
        return super.save(model);
    }

    /**
    * 删除示例实体
    * @param id 示例实体id
    * @return 是否删除成功
    */
    @Override
    @DeleteMapping("/{id:^[a-zA-Z0-9]+_[a-zA-Z0-9]+_[a-zA-Z0-9]+$}")
    @ApiOperation("删除示例实体")
    @PreAuthorize("hasAnyAuthority('" + DELETE_PERM + "')")
    public Result<Void> delete(@ApiParam(value = "主键id", required = true) @PathVariable("id") String id) {
        return super.delete(id);
    }


    /**
    * 根据 id 更新示例实体
    * @param id id 示例实体id
    * @param model 更新的示例实体
    * @return 更新后的结果
    */
    @Override
    @PutMapping("/{id:^[a-zA-Z0-9]+_[a-zA-Z0-9]+_[a-zA-Z0-9]+$}")
    @ApiOperation("更新示例实体")
    @PreAuthorize("hasAnyAuthority('" + EDIT_PERM + "')")
    public Result<SampleEntity> update(@ApiParam(value = "主键id", required = true) @PathVariable("id") String id, @RequestBody SampleEntity model) {
        return super.update(id, model);
    }

    /**
    * 查询所有示例实体
    * @param model JPA Example 查询条件
    * @return 查询结果
    */
    @Override
    @GetMapping
    @ApiOperation("查询所有示例实体")
    @PreAuthorize("hasAnyAuthority('" + QUERY_PERM + "')")
    public Result<List<SampleEntity>> findAll(SampleEntity model) {
        return super.findAll(model);
    }

    /**
    * 分页查询示例实体列表
    * @param page 页码
    * @param size 每页行数
    * @param model JPA Example 查询条件
    * @return 查询结果
    */
    @Override
    @GetMapping("/{page:[0-9]+}/{size:[0-9]+}")
    @ApiOperation("分页查询示例实体列表")
    @PreAuthorize("hasAnyAuthority('" + QUERY_PERM + "')")
    public Result<QueryResult<SampleEntity>> query(@ApiParam(value = "页码", required = true) @PathVariable("page") int page, @ApiParam(value = "每页数据条数", required = true) @PathVariable("size") int size, SampleEntity model) {
        return super.query(page, size, model);
    }

    /**
    * 根据ID查询示例实体
    * @param id 示例实体id
    * @return 示例实体
    */
    @Override
    @GetMapping("/{id:^[a-zA-Z0-9]+_[a-zA-Z0-9]+_[a-zA-Z0-9]+$}")
    @ApiOperation("根据ID查询示例实体")
    @PreAuthorize("hasAnyAuthority('" + QUERY_PERM + "')")
    public Result<SampleEntity> findById(@ApiParam(value = "主键id", required = true) @PathVariable("id") String id) {
        return super.findById(id);
    }

    /**
    * 从文件导入示例实体
    * @param file 上传的文件,支持 excel, json, xml
    * @return 导入成功的示例实体
    * @throws IOException 文件读写异常
    */
    @Override
    @PostMapping("/import")
    @ApiOperation("从文件导入示例实体")
    @PreAuthorize("hasAnyAuthority('" + IMPORT_PERM + "')")
    public Result<List<SampleEntity>> importData(MultipartFile file) throws IOException {
        return super.importData(file);
    }

    /**
    * 将在 ids 列表中的示例实体导出到 Excel
    * @param ids 示例实体id列表
    */
    @Override
    @GetMapping("/export")
    @ApiOperation("导出示例实体到文件")
    @PreAuthorize("permitAll()")
    public void exportData(@RequestParam(required = false) List<String> ids) throws IOException {
        super.exportData(ids);
    }

    /**
    * 批量操作示例实体
    * @param batch 批量操作参数
    * @return 操作结果
    */
    @Override
    @PostMapping("/batch")
    @ApiOperation("批量操作示例实体")
    @PreAuthorize("hasAuthority('" + ADD_PERM +"') and hasAuthority('" + EDIT_PERM +"') and hasAuthority('" + DELETE_PERM +"')")
    public Result batch(@RequestBody BatchModel<SampleEntity> batch) {
        return super.batch(batch);
    }



}