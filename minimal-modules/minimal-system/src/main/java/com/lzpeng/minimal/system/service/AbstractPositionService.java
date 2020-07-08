package com.lzpeng.minimal.system.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.lzpeng.minimal.common.jpa.service.LeftTreeRightTableService;
import com.lzpeng.minimal.system.domain.entity.Position;
import com.lzpeng.minimal.system.repository.PositionRepository;
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
* 岗位 抽象业务层 提供基于注解的缓存配置
* @author: JpaCodeGenerator
*/
@Service
@Transactional(rollbackOn = Exception.class)
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-27 12:42:04", comments = "岗位 抽象业务层 提供基于注解的缓存配置")
public abstract class AbstractPositionService extends LeftTreeRightTableService<Department, Position> {


    /**
    * 岗位实体类类全路径
    */
    protected static final String ENTITY_NAME = "com.lzpeng.minimal.system.domain.entity.Position";

    /**
    * 岗位Repository
    */
    protected PositionRepository positionRepository;

    /**
    * 部门Service(左树)
    */
    protected DepartmentService departmentService;

    /**
    * IOC自动注入岗位Repository
    * @param positionRepository 岗位Repository
    */
    @Autowired
    public void setPositionRepository(PositionRepository positionRepository) {
        this.baseRepository = positionRepository;
        this.leftTreeRightTableRepository = positionRepository;
        this.positionRepository = positionRepository;
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
    * 保存岗位
    * @param position 岗位数据
    * @return 保存之后的岗位
    */
    @Override
    @CachePut(value = ENTITY_NAME, key = "#result.id", unless = "#result == null")
    public Position save(Position position) {
        return super.save(position);
    }

    /**
    * 删除岗位
    * @param id 岗位id
    */
    @Override
    @CacheEvict(value = ENTITY_NAME, key = "#id")
    public void delete(String id) {
        super.delete(id);
    }

    /**
    * 根据 id 更新岗位
    * @param id id 岗位id
    * @param model 更新的岗位
    * @return 更新后的结果
    */
    @Override
    @CachePut(value = ENTITY_NAME, key = "#id", unless = "#result == null")
    public Position update(String id, Position model) {
        return super.update(id, model);
    }

    /**
    * 根据ID查询岗位
    * @param id 岗位id
    * @return 岗位
    */
    @Override
    @Cacheable(value = ENTITY_NAME, key = "#id", unless = "#result == null")
    public Position findById(String id) {
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
    public List<Position> readDataFromJson(String json) throws JsonProcessingException {
        List<Position> list = objectMapper.readValue(json, new TypeReference<List<Position>>() {
        });
        return list;
    }

}
