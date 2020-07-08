package com.lzpeng.minimal.system.controller;

import com.lzpeng.minimal.common.core.response.QueryResult;
import com.lzpeng.minimal.common.core.response.Result;
import com.lzpeng.minimal.common.core.domain.TableDictionary;
import com.lzpeng.minimal.common.jpa.controller.BaseController;
import com.lzpeng.minimal.common.jpa.domain.dto.BatchModel;
import com.lzpeng.minimal.system.domain.entity.NotificationRecord;
import com.lzpeng.minimal.system.service.NotificationRecordService;
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
* 通知记录抽象控制器 提供增删改查接口
* @author: JpaCodeGenerator
*/
@Slf4j
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-27 12:42:04", comments = "抽象通知记录控制层,提供增删改查接口")
public class AbstractNotificationRecordController extends BaseController<NotificationRecord> {

    /**
    * 模块名称
    */
    protected static final String MODULE_NAME = "system";
    /**
    * 通知记录实体类类名称
    */
    protected static final String CLASS_NAME = "notificationRecord";
    /**
    * 通知记录列表权限
    */
    protected static final String LIST_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":list";
    /**
    * 通知记录查询权限
    */
    protected static final String QUERY_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":query";
    /**
    * 通知记录新增权限
    */
    protected static final String ADD_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":add";
    /**
    * 通知记录删除权限
    */
    protected static final String DELETE_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":delete";
    /**
    * 通知记录修改权限
    */
    protected static final String EDIT_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":edit";
    /**
    * 通知记录导出权限
    */
    protected static final String EXPORT_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":export";
    /**
    * 通知记录导入权限
    */
    protected static final String IMPORT_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":import";

    /**
    * 通知记录Service
    */
    protected NotificationRecordService notificationRecordService;

    /**
    * IOC自动注入通知记录Service
    * @param notificationRecordService 通知记录Service
    */
    @Autowired
    public void setNotificationRecordService(NotificationRecordService notificationRecordService) {
        this.baseService = notificationRecordService;
        this.baseService = notificationRecordService;
        this.notificationRecordService = notificationRecordService;
    }

    /**
    * 获取通知记录的数据字典
    * @return 通知记录的数据字典
    */
    @Override
    @GetMapping("/dict")
    @ApiOperation("获取通知记录的数据字典")
    @PreAuthorize("hasAnyAuthority('" + LIST_PERM + "')")
    public Result<TableDictionary> getTableDictionary() {
        return super.getTableDictionary();
    }

    /**
    * 保存通知记录
    * @param model 通知记录数据
    * @return 保存之后的通知记录
    */
    @Override
    @PostMapping
    @ApiOperation("保存通知记录")
    @PreAuthorize("hasAnyAuthority('" + ADD_PERM + "')")
    public Result<NotificationRecord> save(@Valid @RequestBody NotificationRecord model) {
        return super.save(model);
    }

    /**
    * 删除通知记录
    * @param id 通知记录id
    * @return 是否删除成功
    */
    @Override
    @DeleteMapping("/{id:^[a-zA-Z0-9]+_[a-zA-Z0-9]+_[a-zA-Z0-9]+$}")
    @ApiOperation("删除通知记录")
    @PreAuthorize("hasAnyAuthority('" + DELETE_PERM + "')")
    public Result<Void> delete(@ApiParam(value = "主键id", required = true) @PathVariable("id") String id) {
        return super.delete(id);
    }


    /**
    * 根据 id 更新通知记录
    * @param id id 通知记录id
    * @param model 更新的通知记录
    * @return 更新后的结果
    */
    @Override
    @PutMapping("/{id:^[a-zA-Z0-9]+_[a-zA-Z0-9]+_[a-zA-Z0-9]+$}")
    @ApiOperation("更新通知记录")
    @PreAuthorize("hasAnyAuthority('" + EDIT_PERM + "')")
    public Result<NotificationRecord> update(@ApiParam(value = "主键id", required = true) @PathVariable("id") String id, @RequestBody NotificationRecord model) {
        return super.update(id, model);
    }

    /**
    * 查询所有通知记录
    * @param model JPA Example 查询条件
    * @return 查询结果
    */
    @Override
    @GetMapping
    @ApiOperation("查询所有通知记录")
    @PreAuthorize("hasAnyAuthority('" + QUERY_PERM + "')")
    public Result<List<NotificationRecord>> findAll(NotificationRecord model) {
        return super.findAll(model);
    }

    /**
    * 分页查询通知记录列表
    * @param page 页码
    * @param size 每页行数
    * @param model JPA Example 查询条件
    * @return 查询结果
    */
    @Override
    @GetMapping("/{page:[0-9]+}/{size:[0-9]+}")
    @ApiOperation("分页查询通知记录列表")
    @PreAuthorize("hasAnyAuthority('" + QUERY_PERM + "')")
    public Result<QueryResult<NotificationRecord>> query(@ApiParam(value = "页码", required = true) @PathVariable("page") int page, @ApiParam(value = "每页数据条数", required = true) @PathVariable("size") int size, NotificationRecord model) {
        return super.query(page, size, model);
    }

    /**
    * 根据ID查询通知记录
    * @param id 通知记录id
    * @return 通知记录
    */
    @Override
    @GetMapping("/{id:^[a-zA-Z0-9]+_[a-zA-Z0-9]+_[a-zA-Z0-9]+$}")
    @ApiOperation("根据ID查询通知记录")
    @PreAuthorize("hasAnyAuthority('" + QUERY_PERM + "')")
    public Result<NotificationRecord> findById(@ApiParam(value = "主键id", required = true) @PathVariable("id") String id) {
        return super.findById(id);
    }

    /**
    * 从文件导入通知记录
    * @param file 上传的文件,支持 excel, json, xml
    * @return 导入成功的通知记录
    * @throws IOException 文件读写异常
    */
    @Override
    @PostMapping("/import")
    @ApiOperation("从文件导入通知记录")
    @PreAuthorize("hasAnyAuthority('" + IMPORT_PERM + "')")
    public Result<List<NotificationRecord>> importData(MultipartFile file) throws IOException {
        return super.importData(file);
    }

    /**
    * 将在 ids 列表中的通知记录导出到 Excel
    * @param ids 通知记录id列表
    */
    @Override
    @GetMapping("/export")
    @ApiOperation("导出通知记录到文件")
    @PreAuthorize("permitAll()")
    public void exportData(@RequestParam(required = false) List<String> ids) throws IOException {
        super.exportData(ids);
    }

    /**
    * 批量操作通知记录
    * @param batch 批量操作参数
    * @return 操作结果
    */
    @Override
    @PostMapping("/batch")
    @ApiOperation("批量操作通知记录")
    @PreAuthorize("hasAuthority('" + ADD_PERM +"') and hasAuthority('" + EDIT_PERM +"') and hasAuthority('" + DELETE_PERM +"')")
    public Result batch(@RequestBody BatchModel<NotificationRecord> batch) {
        return super.batch(batch);
    }



}