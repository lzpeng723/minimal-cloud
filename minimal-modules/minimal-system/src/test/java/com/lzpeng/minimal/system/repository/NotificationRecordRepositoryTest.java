package com.lzpeng.minimal.system.repository;

import com.lzpeng.minimal.system.domain.entity.NotificationRecord;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Generated;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
* 通知记录 数据层单元测试
* @author: Lzpeng
*/
@Slf4j
@ExtendWith(SpringExtension.class)
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-25 2:02:06", comments = "通知记录 数据层单元测试")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class NotificationRecordRepositoryTest {

    /**
    * 通知记录Repository
    */
    @Autowired
    private NotificationRecordRepository notificationRecordRepository;

    /**
    * 保存通知记录测试
    */
    @Test
    public void testSave(){
        NotificationRecord notificationRecord = new NotificationRecord();
        notificationRecord = notificationRecordRepository.save(notificationRecord);
        assertNotNull(notificationRecord.getId());
    }

    /**
    * 删除通知记录测试
    */
    @Test
    public void testDelete(){
        String id = "{}";
        notificationRecordRepository.deleteById(id);
    }

    /**
    * 更新通知记录测试
    */
    @Test
    public void testUpdate(){
        String id = "{}";
        Optional<NotificationRecord> optional = notificationRecordRepository.findById(id);
        optional.ifPresent(notificationRecord -> {
            notificationRecord = notificationRecordRepository.save(notificationRecord);
            assertEquals(notificationRecord.getId(), id);
        });
    }

    /**
    * 查询所有通知记录测试
    */
    @Test
    public void testFindAll(){
        Page<NotificationRecord> notificationRecordPage = notificationRecordRepository.findAll(PageRequest.of(0, 10));
        assertNotNull(notificationRecordPage.getContent());
    }

    /**
    * 根据id查询通知记录测试
    */
    @Test
    public void testFindById(){
        String id = "{}";
        Optional<NotificationRecord> optional = notificationRecordRepository.findById(id);
        NotificationRecord notificationRecord = optional.orElse(null);
        assertNotNull(notificationRecord);
    }
}