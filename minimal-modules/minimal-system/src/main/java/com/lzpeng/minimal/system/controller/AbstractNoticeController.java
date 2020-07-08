package com.lzpeng.minimal.system.controller;

import com.lzpeng.minimal.common.core.response.QueryResult;
import com.lzpeng.minimal.common.core.response.Result;
import com.lzpeng.minimal.common.core.domain.TableDictionary;
import com.lzpeng.minimal.common.jpa.controller.BaseController;
import com.lzpeng.minimal.common.jpa.domain.dto.BatchModel;
import com.lzpeng.minimal.system.domain.entity.Notice;
import com.lzpeng.minimal.system.service.NoticeService;
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
* 通知抽象控制器 提供增删改查接口
* @author: JpaCodeGenerator
*/
@Slf4j
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-27 12:42:04", comments = "抽象通知控制层,提供增删改查接口")
public class AbstractNoticeController extends BaseController<Notice> {

    /**
    * 模块名称
    */
    protected static final String MODULE_NAME = "system";
    /**
    * 通知实体类类名称
    */
    protected static final String CLASS_NAME = "notice";
    /**
    * 通知列表权限
    */
    protected static final String LIST_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":list";
    /**
    * 通知查询权限
    */
    protected static final String QUERY_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":query";
    /**
    * 通知新增权限
    */
    protected static final String ADD_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":add";
    /**
    * 通知删除权限
    */
    protected static final String DELETE_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":delete";
    /**
    * 通知修改权限
    */
    protected static final String EDIT_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":edit";
    /**
    * 通知导出权限
    */
    protected static final String EXPORT_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":export";
    /**
    * 通知导入权限
    */
    protected static final String IMPORT_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":import";

    /**
    * 通知Service
    */
    protected NoticeService noticeService;

    /**
    * IOC自动注入通知Service
    * @param noticeService 通知Service
    */
    @Autowired
    public void setNoticeService(NoticeService noticeService) {
        this.baseService = noticeService;
        this.baseService = noticeService;
        this.noticeService = noticeService;
    }

    /**
    * 获取通知的数据字典
    * @return 通知的数据字典
    */
    @Override
    @GetMapping("/dict")
    @ApiOperation("获取通知的数据字典")
    @PreAuthorize("hasAnyAuthority('" + LIST_PERM + "')")
    public Result<TableDictionary> getTableDictionary() {
        return super.getTableDictionary();
    }

    /**
    * 保存通知
    * @param model 通知数据
    * @return 保存之后的通知
    */
    @Override
    @PostMapping
    @ApiOperation("保存通知")
    @PreAuthorize("hasAnyAuthority('" + ADD_PERM + "')")
    public Result<Notice> save(@Valid @RequestBody Notice model) {
        return super.save(model);
    }

    /**
    * 删除通知
    * @param id 通知id
    * @return 是否删除成功
    */
    @Override
    @DeleteMapping("/{id:^[a-zA-Z0-9]+_[a-zA-Z0-9]+_[a-zA-Z0-9]+$}")
    @ApiOperation("删除通知")
    @PreAuthorize("hasAnyAuthority('" + DELETE_PERM + "')")
    public Result<Void> delete(@ApiParam(value = "主键id", required = true) @PathVariable("id") String id) {
        return super.delete(id);
    }


    /**
    * 根据 id 更新通知
    * @param id id 通知id
    * @param model 更新的通知
    * @return 更新后的结果
    */
    @Override
    @PutMapping("/{id:^[a-zA-Z0-9]+_[a-zA-Z0-9]+_[a-zA-Z0-9]+$}")
    @ApiOperation("更新通知")
    @PreAuthorize("hasAnyAuthority('" + EDIT_PERM + "')")
    public Result<Notice> update(@ApiParam(value = "主键id", required = true) @PathVariable("id") String id, @RequestBody Notice model) {
        return super.update(id, model);
    }

    /**
    * 查询所有通知
    * @param model JPA Example 查询条件
    * @return 查询结果
    */
    @Override
    @GetMapping
    @ApiOperation("查询所有通知")
    @PreAuthorize("hasAnyAuthority('" + QUERY_PERM + "')")
    public Result<List<Notice>> findAll(Notice model) {
        return super.findAll(model);
    }

    /**
    * 分页查询通知列表
    * @param page 页码
    * @param size 每页行数
    * @param model JPA Example 查询条件
    * @return 查询结果
    */
    @Override
    @GetMapping("/{page:[0-9]+}/{size:[0-9]+}")
    @ApiOperation("分页查询通知列表")
    @PreAuthorize("hasAnyAuthority('" + QUERY_PERM + "')")
    public Result<QueryResult<Notice>> query(@ApiParam(value = "页码", required = true) @PathVariable("page") int page, @ApiParam(value = "每页数据条数", required = true) @PathVariable("size") int size, Notice model) {
        return super.query(page, size, model);
    }

    /**
    * 根据ID查询通知
    * @param id 通知id
    * @return 通知
    */
    @Override
    @GetMapping("/{id:^[a-zA-Z0-9]+_[a-zA-Z0-9]+_[a-zA-Z0-9]+$}")
    @ApiOperation("根据ID查询通知")
    @PreAuthorize("hasAnyAuthority('" + QUERY_PERM + "')")
    public Result<Notice> findById(@ApiParam(value = "主键id", required = true) @PathVariable("id") String id) {
        return super.findById(id);
    }

    /**
    * 从文件导入通知
    * @param file 上传的文件,支持 excel, json, xml
    * @return 导入成功的通知
    * @throws IOException 文件读写异常
    */
    @Override
    @PostMapping("/import")
    @ApiOperation("从文件导入通知")
    @PreAuthorize("hasAnyAuthority('" + IMPORT_PERM + "')")
    public Result<List<Notice>> importData(MultipartFile file) throws IOException {
        return super.importData(file);
    }

    /**
    * 将在 ids 列表中的通知导出到 Excel
    * @param ids 通知id列表
    */
    @Override
    @GetMapping("/export")
    @ApiOperation("导出通知到文件")
    @PreAuthorize("permitAll()")
    public void exportData(@RequestParam(required = false) List<String> ids) throws IOException {
        super.exportData(ids);
    }

    /**
    * 批量操作通知
    * @param batch 批量操作参数
    * @return 操作结果
    */
    @Override
    @PostMapping("/batch")
    @ApiOperation("批量操作通知")
    @PreAuthorize("hasAuthority('" + ADD_PERM +"') and hasAuthority('" + EDIT_PERM +"') and hasAuthority('" + DELETE_PERM +"')")
    public Result batch(@RequestBody BatchModel<Notice> batch) {
        return super.batch(batch);
    }



}