package com.lzpeng.minimal.tool.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.lzpeng.minimal.common.jpa.service.BaseService;
import com.lzpeng.minimal.tool.domain.entity.Gen;
import com.lzpeng.minimal.tool.repository.GenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Generated;
import javax.transaction.Transactional;
import java.util.List;

/**
* 代码生成模板 抽象业务层 提供基于注解的缓存配置
* @author: JpaCodeGenerator
*/
@Service
@Transactional(rollbackOn = Exception.class)
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-27 23:21:56", comments = "代码生成模板 抽象业务层 提供基于注解的缓存配置")
public abstract class AbstractGenService extends BaseService<Gen> {


    /**
    * 代码生成模板实体类类全路径
    */
    protected static final String ENTITY_NAME = "com.lzpeng.minimal.tool.domain.entity.Gen";

    /**
    * 代码生成模板Repository
    */
    protected GenRepository genRepository;

    /**
    * IOC自动注入代码生成模板Repository
    * @param genRepository 代码生成模板Repository
    */
    @Autowired
    public void setGenRepository(GenRepository genRepository) {
        this.baseRepository = genRepository;
        this.baseRepository = genRepository;
        this.genRepository = genRepository;
    }


    /**
    * 保存代码生成模板
    * @param gen 代码生成模板数据
    * @return 保存之后的代码生成模板
    */
    @Override
    @CachePut(value = ENTITY_NAME, key = "#result.id", unless = "#result == null")
    public Gen save(Gen gen) {
        return super.save(gen);
    }

    /**
    * 删除代码生成模板
    * @param id 代码生成模板id
    */
    @Override
    @CacheEvict(value = ENTITY_NAME, key = "#id")
    public void delete(String id) {
        super.delete(id);
    }

    /**
    * 根据 id 更新代码生成模板
    * @param id id 代码生成模板id
    * @param model 更新的代码生成模板
    * @return 更新后的结果
    */
    @Override
    @CachePut(value = ENTITY_NAME, key = "#id", unless = "#result == null")
    public Gen update(String id, Gen model) {
        return super.update(id, model);
    }

    /**
    * 根据ID查询代码生成模板
    * @param id 代码生成模板id
    * @return 代码生成模板
    */
    @Override
    @Cacheable(value = ENTITY_NAME, key = "#id", unless = "#result == null")
    public Gen findById(String id) {
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
    public List<Gen> readDataFromJson(String json) throws JsonProcessingException {
        List<Gen> list = objectMapper.readValue(json, new TypeReference<List<Gen>>() {
        });
        return list;
    }

}
