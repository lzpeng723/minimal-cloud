package com.lzpeng.minimal.system.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.lzpeng.minimal.common.jpa.service.BaseService;
import com.lzpeng.minimal.system.domain.entity.Notice;
import com.lzpeng.minimal.system.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Generated;
import javax.transaction.Transactional;
import java.util.List;

/**
* 通知 抽象业务层 提供基于注解的缓存配置
* @author: JpaCodeGenerator
*/
@Service
@Transactional(rollbackOn = Exception.class)
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-27 12:42:04", comments = "通知 抽象业务层 提供基于注解的缓存配置")
public abstract class AbstractNoticeService extends BaseService<Notice> {


    /**
    * 通知实体类类全路径
    */
    protected static final String ENTITY_NAME = "com.lzpeng.minimal.system.domain.entity.Notice";

    /**
    * 通知Repository
    */
    protected NoticeRepository noticeRepository;

    /**
    * IOC自动注入通知Repository
    * @param noticeRepository 通知Repository
    */
    @Autowired
    public void setNoticeRepository(NoticeRepository noticeRepository) {
        this.baseRepository = noticeRepository;
        this.baseRepository = noticeRepository;
        this.noticeRepository = noticeRepository;
    }


    /**
    * 保存通知
    * @param notice 通知数据
    * @return 保存之后的通知
    */
    @Override
    @CachePut(value = ENTITY_NAME, key = "#result.id", unless = "#result == null")
    public Notice save(Notice notice) {
        return super.save(notice);
    }

    /**
    * 删除通知
    * @param id 通知id
    */
    @Override
    @CacheEvict(value = ENTITY_NAME, key = "#id")
    public void delete(String id) {
        super.delete(id);
    }

    /**
    * 根据 id 更新通知
    * @param id id 通知id
    * @param model 更新的通知
    * @return 更新后的结果
    */
    @Override
    @CachePut(value = ENTITY_NAME, key = "#id", unless = "#result == null")
    public Notice update(String id, Notice model) {
        return super.update(id, model);
    }

    /**
    * 根据ID查询通知
    * @param id 通知id
    * @return 通知
    */
    @Override
    @Cacheable(value = ENTITY_NAME, key = "#id", unless = "#result == null")
    public Notice findById(String id) {
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
    public List<Notice> readDataFromJson(String json) throws JsonProcessingException {
        List<Notice> list = objectMapper.readValue(json, new TypeReference<List<Notice>>() {
        });
        return list;
    }

}
