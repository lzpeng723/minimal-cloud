package com.lzpeng.minimal.system.service;

import cn.hutool.core.io.FileUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.lzpeng.minimal.common.core.response.QueryResult;
import com.lzpeng.minimal.system.domain.entity.Notice;
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
* 通知 业务层单元测试
* @author: JpaCodeGenerator
*/
@Slf4j
@ExtendWith(SpringExtension.class)
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-27 12:07:44", comments = "通知 业务层单元测试")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class NoticeServiceTest {

    /**
    * 通知Service
    */
    @Autowired
    private NoticeService noticeService;

    /**
    * 保存通知测试
    */
    @Test
    public void testSave() {
        Notice notice = new Notice();
        notice = noticeService.save(notice);
        assertNotNull(notice.getId());
    }

    /**
    * 删除通知测试
    */
    @Test
    public void testDelete() {
        String id = "{}";
        noticeService.delete(id);
    }

    /**
    * 更新通知测试
    */
    @Test
    public void testUpdate() {
        String id = "{}";
        Notice notice = new Notice();
        notice = noticeService.update(id, notice);
        assertEquals(notice.getId(), id);
    }

    /**
    * 根据id查询通知测试
    */
    @Test
    public void testFindById() {
        String id = "{}";
        Notice notice = noticeService.findById(id);
        assertEquals(notice.getId(), id);
    }

    /**
    * 分页查询通知测试
    */
    @Test
    public void testQuery() {
        Notice notice = new Notice();
        QueryResult<Notice> result = noticeService.query(0, 10, notice);
        assertNotNull(result.getList());
    }

    /**
    * 读取JSON文件测试
    */
    @Test
    public void testReadDataFromJson() throws JsonProcessingException {
        String path = ""; // json File Path
        String json = FileUtil.readString(path, Charset.defaultCharset());
        Collection<Notice> notices = noticeService.readDataFromJson(json);
        assertNotNull(notices);
        log.info("{}", notices);
    }

    /**
    * 从JSON文件导入通知测试
    */
    @Test
    public void testImportDataFromJson() throws JsonProcessingException {
        String path = ""; // json File Path
        String json = FileUtil.readString(path, Charset.defaultCharset());
        Collection<Notice> notices = noticeService.importDataFromJson(json);
        assertNotNull(notices);
        log.info("{}", notices);
    }

}