package com.lzpeng.minimal.samplejpa.service;

import cn.hutool.core.io.FileUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.lzpeng.minimal.common.core.response.QueryResult;
import com.lzpeng.minimal.samplejpa.domain.entity.SampleEntity;
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
* 示例实体 业务层单元测试
* @author: JpaCodeGenerator
*/
@Slf4j
@ExtendWith(SpringExtension.class)
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-28 20:50:57", comments = "示例实体 业务层单元测试")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class SampleEntityServiceTest {

    /**
    * 示例实体Service
    */
    @Autowired
    private SampleEntityService sampleEntityService;

    /**
    * 保存示例实体测试
    */
    @Test
    public void testSave() {
        SampleEntity sampleEntity = new SampleEntity();
        sampleEntity.setNotBlank("asf");
        sampleEntity.setFixedLength("1234355");
        sampleEntity = sampleEntityService.save(sampleEntity);
        assertNotNull(sampleEntity.getId());
    }

    /**
    * 删除示例实体测试
    */
    @Test
    public void testDelete() {
        String id = "{}";
        sampleEntityService.delete(id);
    }

    /**
    * 更新示例实体测试
    */
    @Test
    public void testUpdate() {
        String id = "{}";
        SampleEntity sampleEntity = new SampleEntity();
        sampleEntity = sampleEntityService.update(id, sampleEntity);
        assertEquals(sampleEntity.getId(), id);
    }

    /**
    * 根据id查询示例实体测试
    */
    @Test
    public void testFindById() {
        String id = "{}";
        SampleEntity sampleEntity = sampleEntityService.findById(id);
        assertEquals(sampleEntity.getId(), id);
    }

    /**
    * 分页查询示例实体测试
    */
    @Test
    public void testQuery() {
        SampleEntity sampleEntity = new SampleEntity();
        QueryResult<SampleEntity> result = sampleEntityService.query(0, 10, sampleEntity);
        assertNotNull(result.getList());
    }

    /**
    * 读取JSON文件测试
    */
    @Test
    public void testReadDataFromJson() throws JsonProcessingException {
        String path = ""; // json File Path
        String json = FileUtil.readString(path, Charset.defaultCharset());
        Collection<SampleEntity> sampleEntitys = sampleEntityService.readDataFromJson(json);
        assertNotNull(sampleEntitys);
        log.info("{}", sampleEntitys);
    }

    /**
    * 从JSON文件导入示例实体测试
    */
    @Test
    public void testImportDataFromJson() throws JsonProcessingException {
        String path = ""; // json File Path
        String json = FileUtil.readString(path, Charset.defaultCharset());
        Collection<SampleEntity> sampleEntitys = sampleEntityService.importDataFromJson(json);
        assertNotNull(sampleEntitys);
        log.info("{}", sampleEntitys);
    }

}