package ${baseModulePackage}.controller;

import ${baseProjectPackage}.common.core.response.QueryResult;
import ${baseProjectPackage}.common.core.response.Result;
import ${baseProjectPackage}.common.core.domain.TableDictionary;
import ${baseProjectPackage}.common.jpa.domain.dto.BatchModel;
import ${baseProjectPackage}.common.jpa.controller.${entityType}Controller;
import ${fullClassName};
import ${baseModulePackage}.service.${simpleClassName}Service;<#if entityType=="LeftTreeRightTable">
import ${leftTree.fullClassName};</#if>
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
* ${chineseClassName}抽象控制器 提供增删改查接口
* @author: ${author!'JpaCodeGenerator'}
*/
@Slf4j
@Generated(value = "${generateClassName}", date = "${.now?date} ${.now?time}", comments = "抽象${chineseClassName}控制层,提供增删改查接口")
public class Abstract${simpleClassName}Controller extends ${entityType}Controller<<#if entityType=="LeftTreeRightTable">${leftTree.simpleClassName}, </#if>${simpleClassName}> {

    /**
    * 模块名称
    */
    protected static final String MODULE_NAME = "${moduleName}";
    /**
    * ${chineseClassName}实体类类名称
    */
    protected static final String CLASS_NAME = "${simpleClassName?uncap_first}";
    /**
    * ${chineseClassName}列表权限
    */
    protected static final String LIST_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":list";
    /**
    * ${chineseClassName}查询权限
    */
    protected static final String QUERY_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":query";
    /**
    * ${chineseClassName}新增权限
    */
    protected static final String ADD_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":add";
    /**
    * ${chineseClassName}删除权限
    */
    protected static final String DELETE_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":delete";
    /**
    * ${chineseClassName}修改权限
    */
    protected static final String EDIT_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":edit";
    /**
    * ${chineseClassName}导出权限
    */
    protected static final String EXPORT_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":export";
    /**
    * ${chineseClassName}导入权限
    */
    protected static final String IMPORT_PERM = MODULE_NAME + ":" +  CLASS_NAME + ":import";

    /**
    * ${chineseClassName}Service
    */
    protected ${simpleClassName}Service ${simpleClassName?uncap_first}Service;

    /**
    * IOC自动注入${chineseClassName}Service
    * @param ${simpleClassName?uncap_first}Service ${chineseClassName}Service
    */
    @Autowired
    public void set${simpleClassName}Service(${simpleClassName}Service ${simpleClassName?uncap_first}Service) {
        this.baseService = ${simpleClassName?uncap_first}Service;<#if entityType??>
        this.${entityType?uncap_first}Service = ${simpleClassName?uncap_first}Service;</#if>
        this.${simpleClassName?uncap_first}Service = ${simpleClassName?uncap_first}Service;
    }

    /**
    * 获取${chineseClassName}的数据字典
    * @return ${chineseClassName}的数据字典
    */
    @Override
    @GetMapping("/dict")
    @ApiOperation("获取${chineseClassName}的数据字典")
    @PreAuthorize("hasAnyAuthority('" + LIST_PERM + "')")
    public Result<TableDictionary> getTableDictionary() {
        return super.getTableDictionary();
    }

    /**
    * 保存${chineseClassName}
    * @param model ${chineseClassName}数据
    * @return 保存之后的${chineseClassName}
    */
    @Override
    @PostMapping
    @ApiOperation("保存${chineseClassName}")
    @PreAuthorize("hasAnyAuthority('" + ADD_PERM + "')")
    public Result<${simpleClassName}> save(@Valid @RequestBody ${simpleClassName} model) {
        return super.save(model);
    }

    /**
    * 删除${chineseClassName}
    * @param id ${chineseClassName}id
    * @return 是否删除成功
    */
    @Override
    @DeleteMapping("/{id:^[a-zA-Z0-9]+_[a-zA-Z0-9]+_[a-zA-Z0-9]+$}")
    @ApiOperation("删除${chineseClassName}")
    @PreAuthorize("hasAnyAuthority('" + DELETE_PERM + "')")
    public Result<Void> delete(@ApiParam(value = "主键id", required = true) @PathVariable("id") String id) {
        return super.delete(id);
    }


    /**
    * 根据 id 更新${chineseClassName}
    * @param id id ${chineseClassName}id
    * @param model 更新的${chineseClassName}
    * @return 更新后的结果
    */
    @Override
    @PutMapping("/{id:^[a-zA-Z0-9]+_[a-zA-Z0-9]+_[a-zA-Z0-9]+$}")
    @ApiOperation("更新${chineseClassName}")
    @PreAuthorize("hasAnyAuthority('" + EDIT_PERM + "')")
    public Result<${simpleClassName}> update(@ApiParam(value = "主键id", required = true) @PathVariable("id") String id, @RequestBody ${simpleClassName} model) {
        return super.update(id, model);
    }

    /**
    * 查询所有${chineseClassName}
    * @param model JPA Example 查询条件
    * @return 查询结果
    */
    @Override
    @GetMapping
    @ApiOperation("查询所有${chineseClassName}")
    @PreAuthorize("hasAnyAuthority('" + QUERY_PERM + "')")
    public Result<List<${simpleClassName}>> findAll(${simpleClassName} model) {
        return super.findAll(model);
    }

    /**
    * 分页查询${chineseClassName}列表
    * @param page 页码
    * @param size 每页行数
    * @param model JPA Example 查询条件
    * @return 查询结果
    */
    @Override
    @GetMapping("/{page:[0-9]+}/{size:[0-9]+}")
    @ApiOperation("分页查询${chineseClassName}列表")
    @PreAuthorize("hasAnyAuthority('" + QUERY_PERM + "')")
    public Result<QueryResult<${simpleClassName}>> query(@ApiParam(value = "页码", required = true) @PathVariable("page") int page, @ApiParam(value = "每页数据条数", required = true) @PathVariable("size") int size, ${simpleClassName} model) {
        return super.query(page, size, model);
    }

    /**
    * 根据ID查询${chineseClassName}
    * @param id ${chineseClassName}id
    * @return ${chineseClassName}
    */
    @Override
    @GetMapping("/{id:^[a-zA-Z0-9]+_[a-zA-Z0-9]+_[a-zA-Z0-9]+$}")
    @ApiOperation("根据ID查询${chineseClassName}")
    @PreAuthorize("hasAnyAuthority('" + QUERY_PERM + "')")
    public Result<${simpleClassName}> findById(@ApiParam(value = "主键id", required = true) @PathVariable("id") String id) {
        return super.findById(id);
    }

    /**
    * 从文件导入${chineseClassName}
    * @param file 上传的文件,支持 excel, json, xml
    * @return 导入成功的${chineseClassName}
    * @throws IOException 文件读写异常
    */
    @Override
    @PostMapping("/import")
    @ApiOperation("从文件导入${chineseClassName}")
    @PreAuthorize("hasAnyAuthority('" + IMPORT_PERM + "')")
    public Result<List<${simpleClassName}>> importData(MultipartFile file) throws IOException {
        return super.importData(file);
    }

    /**
    * 将在 ids 列表中的${chineseClassName}导出到 Excel
    * @param ids ${chineseClassName}id列表
    */
    @Override
    @GetMapping("/export")
    @ApiOperation("导出${chineseClassName}到文件")
    @PreAuthorize("permitAll()")
    public void exportData(@RequestParam(required = false) List<String> ids) throws IOException {
        super.exportData(ids);
    }

    /**
    * 批量操作${chineseClassName}
    * @param batch 批量操作参数
    * @return 操作结果
    */
    @Override
    @PostMapping("/batch")
    @ApiOperation("批量操作${chineseClassName}")
    @PreAuthorize("hasAuthority('" + ADD_PERM +"') and hasAuthority('" + EDIT_PERM +"') and hasAuthority('" + DELETE_PERM +"')")
    public Result batch(@RequestBody BatchModel<${simpleClassName}> batch) {
        return super.batch(batch);
    }

    <#if entityType=="Tree">
    /**
     * 获取树形结构的${chineseClassName}
     * @param model JPA Example 查询条件
     * @return 查询结果
     */
    @Override
    @GetMapping("/tree")
    @ApiOperation("获取树形结构的${chineseClassName}")
    @PreAuthorize("hasAnyAuthority('" + QUERY_PERM + "')")
    public Result<List<${simpleClassName}>> treeData(${simpleClassName} model) {
        return super.treeData(model);
    }
    </#if>

    <#if entityType=="LeftTreeRightTable">
    /**
    * 获取左树数据
    * @return 左树数据
    */
    @Override
    @GetMapping("/leftTree")
    @ApiOperation("获取左树数据")
    @PreAuthorize("hasAnyAuthority('" + QUERY_PERM + "')")
    public Result<List<${leftTree.simpleClassName}>> leftTreeData() {
        return super.leftTreeData();
    }
    </#if>

}