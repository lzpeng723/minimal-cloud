package com.lzpeng.minimal.demo.service;

import cn.hutool.core.io.FileUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.lzpeng.minimal.common.core.response.QueryResult;
import com.lzpeng.minimal.demo.domain.entity.DemoEntity;
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
* 测试实体 业务层单元测试
* @author: JpaCodeGenerator
*/
@Slf4j
@ExtendWith(SpringExtension.class)
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-7-7 18:31:21", comments = "测试实体 业务层单元测试")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class DemoEntityServiceTest {

    /**
    * 测试实体Service
    */
    @Autowired
    private DemoEntityService demoEntityService;

    /**
    * 保存测试实体测试
    */
    @Test
    public void testSave() {
        DemoEntity demoEntity = new DemoEntity();
        demoEntity = demoEntityService.save(demoEntity);
        assertNotNull(demoEntity.getId());
    }

    /**
    * 删除测试实体测试
    */
    @Test
    public void testDelete() {
        String id = "{}";
        demoEntityService.delete(id);
    }

    /**
    * 更新测试实体测试
    */
    @Test
    public void testUpdate() {
        String id = "{}";
        DemoEntity demoEntity = new DemoEntity();
        demoEntity = demoEntityService.update(id, demoEntity);
        assertEquals(demoEntity.getId(), id);
    }

    /**
    * 根据id查询测试实体测试
    */
    @Test
    public void testFindById() {
        String id = "{}";
        DemoEntity demoEntity = demoEntityService.findById(id);
        assertEquals(demoEntity.getId(), id);
    }

    /**
    * 分页查询测试实体测试
    */
    @Test
    public void testQuery() {
        DemoEntity demoEntity = new DemoEntity();
        QueryResult<DemoEntity> result = demoEntityService.query(0, 10, demoEntity);
        assertNotNull(result.getList());
    }

    /**
    * 读取JSON文件测试
    */
    @Test
    public void testReadDataFromJson() throws JsonProcessingException {
        String path = ""; // json File Path
        String json = FileUtil.readString(path, Charset.defaultCharset());
        Collection<DemoEntity> demoEntitys = demoEntityService.readDataFromJson(json);
        assertNotNull(demoEntitys);
        log.info("{}", demoEntitys);
    }

    /**
    * 从JSON文件导入测试实体测试
    */
    @Test
    public void testImportDataFromJson() throws JsonProcessingException {
        String path = ""; // json File Path
        String json = FileUtil.readString(path, Charset.defaultCharset());
        Collection<DemoEntity> demoEntitys = demoEntityService.importDataFromJson(json);
        assertNotNull(demoEntitys);
        log.info("{}", demoEntitys);
    }

}