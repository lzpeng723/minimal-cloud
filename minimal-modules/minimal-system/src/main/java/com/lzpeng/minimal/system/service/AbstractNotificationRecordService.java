package com.lzpeng.minimal.system.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.lzpeng.minimal.common.jpa.service.BaseService;
import com.lzpeng.minimal.system.domain.entity.NotificationRecord;
import com.lzpeng.minimal.system.repository.NotificationRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Generated;
import javax.transaction.Transactional;
import java.util.List;

/**
* 通知记录 抽象业务层 提供基于注解的缓存配置
* @author: JpaCodeGenerator
*/
@Service
@Transactional(rollbackOn = Exception.class)
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-27 12:42:04", comments = "通知记录 抽象业务层 提供基于注解的缓存配置")
public abstract class AbstractNotificationRecordService extends BaseService<NotificationRecord> {


    /**
    * 通知记录实体类类全路径
    */
    protected static final String ENTITY_NAME = "com.lzpeng.minimal.system.domain.entity.NotificationRecord";

    /**
    * 通知记录Repository
    */
    protected NotificationRecordRepository notificationRecordRepository;

    /**
    * IOC自动注入通知记录Repository
    * @param notificationRecordRepository 通知记录Repository
    */
    @Autowired
    public void setNotificationRecordRepository(NotificationRecordRepository notificationRecordRepository) {
        this.baseRepository = notificationRecordRepository;
        this.baseRepository = notificationRecordRepository;
        this.notificationRecordRepository = notificationRecordRepository;
    }


    /**
    * 保存通知记录
    * @param notificationRecord 通知记录数据
    * @return 保存之后的通知记录
    */
    @Override
    @CachePut(value = ENTITY_NAME, key = "#result.id", unless = "#result == null")
    public NotificationRecord save(NotificationRecord notificationRecord) {
        return super.save(notificationRecord);
    }

    /**
    * 删除通知记录
    * @param id 通知记录id
    */
    @Override
    @CacheEvict(value = ENTITY_NAME, key = "#id")
    public void delete(String id) {
        super.delete(id);
    }

    /**
    * 根据 id 更新通知记录
    * @param id id 通知记录id
    * @param model 更新的通知记录
    * @return 更新后的结果
    */
    @Override
    @CachePut(value = ENTITY_NAME, key = "#id", unless = "#result == null")
    public NotificationRecord update(String id, NotificationRecord model) {
        return super.update(id, model);
    }

    /**
    * 根据ID查询通知记录
    * @param id 通知记录id
    * @return 通知记录
    */
    @Override
    @Cacheable(value = ENTITY_NAME, key = "#id", unless = "#result == null")
    public NotificationRecord findById(String id) {
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
    public List<NotificationRecord> readDataFromJson(String json) throws JsonProcessingException {
        List<NotificationRecord> list = objectMapper.readValue(json, new TypeReference<List<NotificationRecord>>() {
        });
        return list;
    }

}
