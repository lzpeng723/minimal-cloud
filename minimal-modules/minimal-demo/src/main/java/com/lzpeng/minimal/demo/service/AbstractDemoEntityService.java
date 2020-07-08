package com.lzpeng.minimal.demo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.lzpeng.minimal.common.jpa.service.BaseService;
import com.lzpeng.minimal.demo.domain.entity.DemoEntity;
import com.lzpeng.minimal.demo.repository.DemoEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Generated;
import javax.transaction.Transactional;
import java.util.List;

/**
* 测试实体 抽象业务层 提供基于注解的缓存配置
* @author: JpaCodeGenerator
*/
@Service
@Transactional(rollbackOn = Exception.class)
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-7-7 18:31:21", comments = "测试实体 抽象业务层 提供基于注解的缓存配置")
public abstract class AbstractDemoEntityService extends BaseService<DemoEntity> {


    /**
    * 测试实体实体类类全路径
    */
    protected static final String ENTITY_NAME = "com.lzpeng.minimal.demo.domain.entity.DemoEntity";

    /**
    * 测试实体Repository
    */
    protected DemoEntityRepository demoEntityRepository;

    /**
    * IOC自动注入测试实体Repository
    * @param demoEntityRepository 测试实体Repository
    */
    @Autowired
    public void setDemoEntityRepository(DemoEntityRepository demoEntityRepository) {
        this.baseRepository = demoEntityRepository;
        this.baseRepository = demoEntityRepository;
        this.demoEntityRepository = demoEntityRepository;
    }


    /**
    * 保存测试实体
    * @param demoEntity 测试实体数据
    * @return 保存之后的测试实体
    */
    @Override
    @CachePut(value = ENTITY_NAME, key = "#result.id", unless = "#result == null")
    public DemoEntity save(DemoEntity demoEntity) {
        return super.save(demoEntity);
    }

    /**
    * 删除测试实体
    * @param id 测试实体id
    */
    @Override
    @CacheEvict(value = ENTITY_NAME, key = "#id")
    public void delete(String id) {
        super.delete(id);
    }

    /**
    * 根据 id 更新测试实体
    * @param id id 测试实体id
    * @param model 更新的测试实体
    * @return 更新后的结果
    */
    @Override
    @CachePut(value = ENTITY_NAME, key = "#id", unless = "#result == null")
    public DemoEntity update(String id, DemoEntity model) {
        return super.update(id, model);
    }

    /**
    * 根据ID查询测试实体
    * @param id 测试实体id
    * @return 测试实体
    */
    @Override
    @Cacheable(value = ENTITY_NAME, key = "#id", unless = "#result == null")
    public DemoEntity findById(String id) {
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
    public List<DemoEntity> readDataFromJson(String json) throws JsonProcessingException {
        List<DemoEntity> list = objectMapper.readValue(json, new TypeReference<List<DemoEntity>>() {
        });
        return list;
    }

}
