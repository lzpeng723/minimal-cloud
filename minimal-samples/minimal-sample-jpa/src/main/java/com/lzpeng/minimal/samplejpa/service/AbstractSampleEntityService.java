package com.lzpeng.minimal.samplejpa.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.lzpeng.minimal.common.jpa.service.BaseService;
import com.lzpeng.minimal.samplejpa.domain.entity.SampleEntity;
import com.lzpeng.minimal.samplejpa.repository.SampleEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Generated;
import javax.transaction.Transactional;
import java.util.List;

/**
* 示例实体 抽象业务层 提供基于注解的缓存配置
* @author: JpaCodeGenerator
*/
@Service
@Transactional(rollbackOn = Exception.class)
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-28 20:50:57", comments = "示例实体 抽象业务层 提供基于注解的缓存配置")
public abstract class AbstractSampleEntityService extends BaseService<SampleEntity> {


    /**
    * 示例实体实体类类全路径
    */
    protected static final String ENTITY_NAME = "com.lzpeng.minimal.samplejpa.domain.entity.SampleEntity";

    /**
    * 示例实体Repository
    */
    protected SampleEntityRepository sampleEntityRepository;

    /**
    * IOC自动注入示例实体Repository
    * @param sampleEntityRepository 示例实体Repository
    */
    @Autowired
    public void setSampleEntityRepository(SampleEntityRepository sampleEntityRepository) {
        this.baseRepository = sampleEntityRepository;
        this.baseRepository = sampleEntityRepository;
        this.sampleEntityRepository = sampleEntityRepository;
    }


    /**
    * 保存示例实体
    * @param sampleEntity 示例实体数据
    * @return 保存之后的示例实体
    */
    @Override
    @CachePut(value = ENTITY_NAME, key = "#result.id", unless = "#result == null")
    public SampleEntity save(SampleEntity sampleEntity) {
        return super.save(sampleEntity);
    }

    /**
    * 删除示例实体
    * @param id 示例实体id
    */
    @Override
    @CacheEvict(value = ENTITY_NAME, key = "#id")
    public void delete(String id) {
        super.delete(id);
    }

    /**
    * 根据 id 更新示例实体
    * @param id id 示例实体id
    * @param model 更新的示例实体
    * @return 更新后的结果
    */
    @Override
    @CachePut(value = ENTITY_NAME, key = "#id", unless = "#result == null")
    public SampleEntity update(String id, SampleEntity model) {
        return super.update(id, model);
    }

    /**
    * 根据ID查询示例实体
    * @param id 示例实体id
    * @return 示例实体
    */
    @Override
    @Cacheable(value = ENTITY_NAME, key = "#id", unless = "#result == null")
    public SampleEntity findById(String id) {
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
    public List<SampleEntity> readDataFromJson(String json) throws JsonProcessingException {
        List<SampleEntity> list = objectMapper.readValue(json, new TypeReference<List<SampleEntity>>() {
        });
        return list;
    }

}
