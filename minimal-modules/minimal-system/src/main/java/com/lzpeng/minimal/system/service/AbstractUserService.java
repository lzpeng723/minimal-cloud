package com.lzpeng.minimal.system.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.lzpeng.minimal.common.jpa.service.LeftTreeRightTableService;
import com.lzpeng.minimal.system.domain.entity.User;
import com.lzpeng.minimal.system.repository.UserRepository;
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
* 用户 抽象业务层 提供基于注解的缓存配置
* @author: JpaCodeGenerator
*/
@Service
@Transactional(rollbackOn = Exception.class)
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-27 12:42:04", comments = "用户 抽象业务层 提供基于注解的缓存配置")
public abstract class AbstractUserService extends LeftTreeRightTableService<Department, User> {


    /**
    * 用户实体类类全路径
    */
    protected static final String ENTITY_NAME = "com.lzpeng.minimal.system.domain.entity.User";

    /**
    * 用户Repository
    */
    protected UserRepository userRepository;

    /**
    * 部门Service(左树)
    */
    protected DepartmentService departmentService;

    /**
    * IOC自动注入用户Repository
    * @param userRepository 用户Repository
    */
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.baseRepository = userRepository;
        this.leftTreeRightTableRepository = userRepository;
        this.userRepository = userRepository;
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
    * 保存用户
    * @param user 用户数据
    * @return 保存之后的用户
    */
    @Override
    @CachePut(value = ENTITY_NAME, key = "#result.id", unless = "#result == null")
    public User save(User user) {
        return super.save(user);
    }

    /**
    * 删除用户
    * @param id 用户id
    */
    @Override
    @CacheEvict(value = ENTITY_NAME, key = "#id")
    public void delete(String id) {
        super.delete(id);
    }

    /**
    * 根据 id 更新用户
    * @param id id 用户id
    * @param model 更新的用户
    * @return 更新后的结果
    */
    @Override
    @CachePut(value = ENTITY_NAME, key = "#id", unless = "#result == null")
    public User update(String id, User model) {
        return super.update(id, model);
    }

    /**
    * 根据ID查询用户
    * @param id 用户id
    * @return 用户
    */
    @Override
    @Cacheable(value = ENTITY_NAME, key = "#id", unless = "#result == null")
    public User findById(String id) {
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
    public List<User> readDataFromJson(String json) throws JsonProcessingException {
        List<User> list = objectMapper.readValue(json, new TypeReference<List<User>>() {
        });
        return list;
    }

}
