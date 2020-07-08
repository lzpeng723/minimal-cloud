package com.lzpeng.minimal.system.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.lzpeng.minimal.common.jpa.service.LeftTreeRightTableService;
import com.lzpeng.minimal.system.domain.entity.Role;
import com.lzpeng.minimal.system.repository.RoleRepository;
import com.lzpeng.minimal.system.domain.entity.Department;
import com.lzpeng.minimal.system.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Generated;
import javax.transaction.Transactional;
import java.util.List;

/**
* 角色 抽象业务层 提供基于注解的缓存配置
* @author: JpaCodeGenerator
*/
@Service
@Transactional(rollbackOn = Exception.class)
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-27 12:42:04", comments = "角色 抽象业务层 提供基于注解的缓存配置")
public abstract class AbstractRoleService extends LeftTreeRightTableService<Department, Role> {


    /**
    * 角色实体类类全路径
    */
    protected static final String ENTITY_NAME = "com.lzpeng.minimal.system.domain.entity.Role";

    /**
    * 角色Repository
    */
    protected RoleRepository roleRepository;

    /**
    * 部门Service(左树)
    */
    protected DepartmentService departmentService;

    /**
    * IOC自动注入角色Repository
    * @param roleRepository 角色Repository
    */
    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.baseRepository = roleRepository;
        this.leftTreeRightTableRepository = roleRepository;
        this.roleRepository = roleRepository;
    }

    /**
    * IOC自动注入部门Service(左树)
    * @param departmentService 部门Service(左树)
    */
    @Autowired
    public void setDepartmentService(DepartmentService departmentService) {
        this.treeService = departmentService;
        this.departmentService = departmentService;
    }


    /**
    * 保存角色
    * @param role 角色数据
    * @return 保存之后的角色
    */
    @Override
    @CachePut(value = ENTITY_NAME, key = "#result.id", unless = "#result == null")
    public Role save(Role role) {
        return super.save(role);
    }

    /**
    * 删除角色
    * @param id 角色id
    */
    @Override
    @CacheEvict(value = ENTITY_NAME, key = "#id")
    public void delete(String id) {
        super.delete(id);
    }

    /**
    * 根据 id 更新角色
    * @param id id 角色id
    * @param model 更新的角色
    * @return 更新后的结果
    */
    @Override
    @CachePut(value = ENTITY_NAME, key = "#id", unless = "#result == null")
    public Role update(String id, Role model) {
        return super.update(id, model);
    }

    /**
    * 根据ID查询角色
    * @param id 角色id
    * @return 角色
    */
    @Override
    @Cacheable(value = ENTITY_NAME, key = "#id", unless = "#result == null")
    public Role findById(String id) {
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
    public List<Role> readDataFromJson(String json) throws JsonProcessingException {
        List<Role> list = objectMapper.readValue(json, new TypeReference<List<Role>>() {
        });
        return list;
    }

}
