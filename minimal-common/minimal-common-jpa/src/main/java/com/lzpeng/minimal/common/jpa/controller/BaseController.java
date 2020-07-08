package com.lzpeng.minimal.common.jpa.controller;

import cn.hutool.core.util.TypeUtil;
import com.lzpeng.minimal.common.core.domain.TableDictionary;
import com.lzpeng.minimal.common.core.response.QueryResult;
import com.lzpeng.minimal.common.core.response.Result;
import com.lzpeng.minimal.common.core.response.ResultUtil;
import com.lzpeng.minimal.common.jpa.domain.dto.BatchModel;
import com.lzpeng.minimal.common.jpa.domain.entity.BaseEntity;
import com.lzpeng.minimal.common.jpa.service.BaseService;
import com.lzpeng.minimal.common.jpa.support.DataDictionaryService;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

/**
 * 基础的Controller
 * @author: Lzpeng
 * 谁说 HTTP GET 就不能通过 Body 来发送数据呢？ https://www.jianshu.com/p/c025273d78db
 */
public class BaseController<Entity extends BaseEntity> extends com.lzpeng.minimal.common.core.controller.BaseController {

    /**
     * 泛型注入
     */
    protected BaseService<Entity> baseService;


    /**
     * 获取当前实体数据字典
     * 不使用懒加载会导致SessionFactory创建失败
     */
    @Lazy
    @Autowired
    private DataDictionaryService dataDictionaryService;

    /**
     * 保存实体
     * @param entity 要保存的实体
     * @return 保存成功的实体
     */
    public Result<Entity> save(Entity entity) {
        entity = baseService.save(entity);
        return ResultUtil.success(entity);
    }

    /**
     * 根据 id 删除实体
     * @param id 实体 id
     */
    public Result<Void> delete(String id) {
        baseService.delete(id);
        return ResultUtil.success();
    }

    /**
     * 根据 id 更新实体
     * @param id id
     * @param model 更新的实体
     * @return 更新后的结果
     */
    public Result<Entity> update(String id, Entity model) {
        Entity entity = baseService.update(id, model);
        return ResultUtil.success(entity);
    }

    /**
     * 根据查询条件和分页条件查询实体
     * @param page 页码
     * @param size 每页行数
     * @param model JPA Example 查询条件
     * @return 符合条件的实体列表
     */
    public Result<QueryResult<Entity>> query(int page, int size, Entity model) {
        QueryResult<Entity> result = baseService.query(page, size, model);
        return ResultUtil.success(result);
    }

    /**
     * 根据查询条件和分页条件查询实体
     * @param page 页码
     * @param size 每页行数
     * @param predicate Query DSL查询条件
     * @return 符合条件的实体列表
     */
    public Result<QueryResult<Entity>> query(int page, int size, Predicate predicate) {
        QueryResult<Entity> result = baseService.query(page, size, predicate);
        return ResultUtil.success(result);
    }

    /**
     * 根据id查询实体
     * @param id id
     * @return 查询到的实体
     */
    public Result<Entity> findById(String id) {
        Entity entity = baseService.findById(id);
        return ResultUtil.success(entity);
    }

    /**
     * 根据查询条件查询实体
     * @param model 模糊查询条件
     * @return 符合条件的实体列表
     */
    public Result<List<Entity>> findAll(Entity model) {
        List<Entity> entities = baseService.findAll(model);
        return ResultUtil.success(entities);
    }

    /**
     * 得到泛型参数
     * @return 实体类型
     */
    protected Class<Entity> getEntityClass(){
        Type type = TypeUtil.getTypeArgument(getClass());
        if (type != null && type instanceof Class) {
            return (Class<Entity>) type;
        }
        return null;
    }


    /**
     * 批量增删改查
     * @param batch 批量操作的数据
     * @return 批量操作结果
     */
    public Result<Object> batch(BatchModel<Entity> batch){
        Object result = baseService.batch(batch);
        return ResultUtil.success(result);
    }

    /**
     * 从文件导入实体
     * @param file 上传的文件
     * @return 导入成功的实体
     */
    public Result<List<Entity>> importData(MultipartFile file) throws IOException {
        List<Entity> list = baseService.importData(file);
        return ResultUtil.success(list);
    }

    /**
     * 将在 ids 列表中的实体导出到 Excel
     * @param ids id列表
     */
    public void exportData(List<String> ids) throws IOException {
        baseService.exportData(ids, response);
    }

    /**
     * 获取数据字典信息
     * @return 数据字典信息
     */
    protected Result<TableDictionary> getTableDictionary() {
        Class<Entity> entityClass = getEntityClass();
        TableDictionary tableDictionary = dataDictionaryService.getTableDictionary(entityClass);
        return ResultUtil.success(tableDictionary);
    }
}
