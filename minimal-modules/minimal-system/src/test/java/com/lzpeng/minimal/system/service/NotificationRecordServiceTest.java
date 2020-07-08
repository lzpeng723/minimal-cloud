package com.lzpeng.minimal.system.service;

import cn.hutool.core.io.FileUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.lzpeng.minimal.common.core.response.QueryResult;
import com.lzpeng.minimal.system.domain.entity.NotificationRecord;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Generated;

import java.nio.charset.Charset;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

/**
* 通知记录 业务层单元测试
* @author: JpaCodeGenerator
*/
@Slf4j
@ExtendWith(SpringExtension.class)
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-27 12:07:44", comments = "通知记录 业务层单元测试")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class NotificationRecordServiceTest {

    /**
    * 通知记录Service
    */
    @Autowired
    private NotificationRecordService notificationRecordService;

    /**
    * 保存通知记录测试
    */
    @Test
    public void testSave() {
        NotificationRecord notificationRecord = new NotificationRecord();
        notificationRecord = notificationRecordService.save(notificationRecord);
        assertNotNull(notificationRecord.getId());
    }

    /**
    * 删除通知记录测试
    */
    @Test
    public void testDelete() {
        String id = "{}";
        notificationRecordService.delete(id);
    }

    /**
    * 更新通知记录测试
    */
    @Test
    public void testUpdate() {
        String id = "{}";
        NotificationRecord notificationRecord = new NotificationRecord();
        notificationRecord = notificationRecordService.update(id, notificationRecord);
        assertEquals(notificationRecord.getId(), id);
    }

    /**
    * 根据id查询通知记录测试
    */
    @Test
    public void testFindById() {
        String id = "{}";
        NotificationRecord notificationRecord = notificationRecordService.findById(id);
        assertEquals(notificationRecord.getId(), id);
    }

    /**
    * 分页查询通知记录测试
    */
    @Test
    public void testQuery() {
        NotificationRecord notificationRecord = new NotificationRecord();
        QueryResult<NotificationRecord> result = notificationRecordService.query(0, 10, notificationRecord);
        assertNotNull(result.getList());
    }

    /**
    * 读取JSON文件测试
    */
    @Test
    public void testReadDataFromJson() throws JsonProcessingException {
        String path = ""; // json File Path
        String json = FileUtil.readString(path, Charset.defaultCharset());
        Collection<NotificationRecord> notificationRecords = notificationRecordService.readDataFromJson(json);
        assertNotNull(notificationRecords);
        log.info("{}", notificationRecords);
    }

    /**
    * 从JSON文件导入通知记录测试
    */
    @Test
    public void testImportDataFromJson() throws JsonProcessingException {
        String path = ""; // json File Path
        String json = FileUtil.readString(path, Charset.defaultCharset());
        Collection<NotificationRecord> notificationRecords = notificationRecordService.importDataFromJson(json);
        assertNotNull(notificationRecords);
        log.info("{}", notificationRecords);
    }

}