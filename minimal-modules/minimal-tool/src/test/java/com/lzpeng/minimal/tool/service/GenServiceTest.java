package com.lzpeng.minimal.tool.service;

import cn.hutool.core.io.FileUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.lzpeng.minimal.common.core.response.QueryResult;
import com.lzpeng.minimal.tool.domain.entity.Gen;
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
* 代码生成模板 业务层单元测试
* @author: JpaCodeGenerator
*/
@Slf4j
@ExtendWith(SpringExtension.class)
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-27 23:21:56", comments = "代码生成模板 业务层单元测试")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class GenServiceTest {

    /**
    * 代码生成模板Service
    */
    @Autowired
    private GenService genService;

    /**
    * 保存代码生成模板测试
    */
    @Test
    public void testSave() {
        Gen gen = new Gen();
        gen = genService.save(gen);
        assertNotNull(gen.getId());
    }

    /**
    * 删除代码生成模板测试
    */
    @Test
    public void testDelete() {
        String id = "{}";
        genService.delete(id);
    }

    /**
    * 更新代码生成模板测试
    */
    @Test
    public void testUpdate() {
        String id = "{}";
        Gen gen = new Gen();
        gen = genService.update(id, gen);
        assertEquals(gen.getId(), id);
    }

    /**
    * 根据id查询代码生成模板测试
    */
    @Test
    public void testFindById() {
        String id = "{}";
        Gen gen = genService.findById(id);
        assertEquals(gen.getId(), id);
    }

    /**
    * 分页查询代码生成模板测试
    */
    @Test
    public void testQuery() {
        Gen gen = new Gen();
        QueryResult<Gen> result = genService.query(0, 10, gen);
        assertNotNull(result.getList());
    }

    /**
    * 读取JSON文件测试
    */
    @Test
    public void testReadDataFromJson() throws JsonProcessingException {
        String path = ""; // json File Path
        String json = FileUtil.readString(path, Charset.defaultCharset());
        Collection<Gen> gens = genService.readDataFromJson(json);
        assertNotNull(gens);
        log.info("{}", gens);
    }

    /**
    * 从JSON文件导入代码生成模板测试
    */
    @Test
    public void testImportDataFromJson() throws JsonProcessingException {
        String path = ""; // json File Path
        String json = FileUtil.readString(path, Charset.defaultCharset());
        Collection<Gen> gens = genService.importDataFromJson(json);
        assertNotNull(gens);
        log.info("{}", gens);
    }

}