package com.lzpeng.minimal.system.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.lzpeng.minimal.common.jpa.service.TreeService;
import com.lzpeng.minimal.system.domain.entity.Department;
import com.lzpeng.minimal.system.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Generated;
import javax.transaction.Transactional;
import java.util.List;

/**
* 部门 抽象业务层 提供基于注解的缓存配置
* @author: JpaCodeGenerator
*/
@Service
@Transactional(rollbackOn = Exception.class)
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-27 12:42:04", comments = "部门 抽象业务层 提供基于注解的缓存配置")
public abstract class AbstractDepartmentService extends TreeService<Department> {


    /**
    * 部门实体类类全路径
    */
    protected static final String ENTITY_NAME = "com.lzpeng.minimal.system.domain.entity.Department";

    /**
    * 部门Repository
    */
    protected DepartmentRepository departmentRepository;

    /**
    * IOC自动注入部门Repository
    * @param departmentRepository 部门Repository
    */
    @Autowired
    public void setDepartmentRepository(DepartmentRepository departmentRepository) {
        this.baseRepository = departmentRepository;
        this.treeRepository = departmentRepository;
        this.departmentRepository = departmentRepository;
    }


    /**
    * 保存部门
    * @param department 部门数据
    * @return 保存之后的部门
    */
    @Override
    @CachePut(value = ENTITY_NAME, key = "#result.id", unless = "#result == null")
    public Department save(Department department) {
        return super.save(department);
    }

    /**
    * 删除部门
    * @param id 部门id
    */
    @Override
    @CacheEvict(value = ENTITY_NAME, key = "#id")
    public void delete(String id) {
        super.delete(id);
    }

    /**
    * 根据 id 更新部门
    * @param id id 部门id
    * @param model 更新的部门
    * @return 更新后的结果
    */
    @Override
    @CachePut(value = ENTITY_NAME, key = "#id", unless = "#result == null")
    public Department update(String id, Department model) {
        return super.update(id, model);
    }

    /**
    * 根据ID查询部门
    * @param id 部门id
    * @return 部门
    */
    @Override
    @Cacheable(value = ENTITY_NAME, key = "#id", unless = "#result == null")
    public Department findById(String id) {
        return super.findById(id);
    }

    /**
    * 从 json 读取实体列表
    * 必须重写此方法否则,TypeReference获取不到泛型参数
    * @param json json字符串
    * @return 实体列表
    * @throws JsonProcessingException json解析异常
    */
    @Override
    public List<Department> readDataFromJson(String json) throws JsonProcessingException {
        List<Department> list = objectMapper.readValue(json, new TypeReference<List<Department>>() {
        });
        return list;
    }

}
