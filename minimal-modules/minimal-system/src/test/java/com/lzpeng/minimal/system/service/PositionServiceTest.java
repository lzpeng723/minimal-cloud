package com.lzpeng.minimal.system.service;

import cn.hutool.core.io.FileUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.lzpeng.minimal.common.core.response.QueryResult;
import com.lzpeng.minimal.system.domain.entity.Position;
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
* 岗位 业务层单元测试
* @author: JpaCodeGenerator
*/
@Slf4j
@ExtendWith(SpringExtension.class)
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-27 12:07:44", comments = "岗位 业务层单元测试")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class PositionServiceTest {

    /**
    * 岗位Service
    */
    @Autowired
    private PositionService positionService;

    /**
    * 保存岗位测试
    */
    @Test
    public void testSave() {
        Position position = new Position();
        position = positionService.save(position);
        assertNotNull(position.getId());
    }

    /**
    * 删除岗位测试
    */
    @Test
    public void testDelete() {
        String id = "{}";
        positionService.delete(id);
    }

    /**
    * 更新岗位测试
    */
    @Test
    public void testUpdate() {
        String id = "{}";
        Position position = new Position();
        position = positionService.update(id, position);
        assertEquals(position.getId(), id);
    }

    /**
    * 根据id查询岗位测试
    */
    @Test
    public void testFindById() {
        String id = "{}";
        Position position = positionService.findById(id);
        assertEquals(position.getId(), id);
    }

    /**
    * 分页查询岗位测试
    */
    @Test
    public void testQuery() {
        Position position = new Position();
        QueryResult<Position> result = positionService.query(0, 10, position);
        assertNotNull(result.getList());
    }

    /**
    * 读取JSON文件测试
    */
    @Test
    public void testReadDataFromJson() throws JsonProcessingException {
        String path = ""; // json File Path
        String json = FileUtil.readString(path, Charset.defaultCharset());
        Collection<Position> positions = positionService.readDataFromJson(json);
        assertNotNull(positions);
        log.info("{}", positions);
    }

    /**
    * 从JSON文件导入岗位测试
    */
    @Test
    public void testImportDataFromJson() throws JsonProcessingException {
        String path = ""; // json File Path
        String json = FileUtil.readString(path, Charset.defaultCharset());
        Collection<Position> positions = positionService.importDataFromJson(json);
        assertNotNull(positions);
        log.info("{}", positions);
    }

}