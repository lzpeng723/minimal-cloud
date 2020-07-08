package com.lzpeng.minimal.system.service;

import cn.hutool.core.io.FileUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.lzpeng.minimal.common.core.response.QueryResult;
import com.lzpeng.minimal.system.domain.entity.Department;
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
* 部门 业务层单元测试
* @author: JpaCodeGenerator
*/
@Slf4j
@ExtendWith(SpringExtension.class)
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-27 12:07:44", comments = "部门 业务层单元测试")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class DepartmentServiceTest {

    /**
    * 部门Service
    */
    @Autowired
    private DepartmentService departmentService;

    /**
    * 保存部门测试
    */
    @Test
    public void testSave() {
        Department department = new Department();
        department = departmentService.save(department);
        assertNotNull(department.getId());
    }

    /**
    * 删除部门测试
    */
    @Test
    public void testDelete() {
        String id = "{}";
        departmentService.delete(id);
    }

    /**
    * 更新部门测试
    */
    @Test
    public void testUpdate() {
        String id = "{}";
        Department department = new Department();
        department = departmentService.update(id, department);
        assertEquals(department.getId(), id);
    }

    /**
    * 根据id查询部门测试
    */
    @Test
    public void testFindById() {
        String id = "{}";
        Department department = departmentService.findById(id);
        assertEquals(department.getId(), id);
    }

    /**
    * 分页查询部门测试
    */
    @Test
    public void testQuery() {
        Department department = new Department();
        QueryResult<Department> result = departmentService.query(0, 10, department);
        assertNotNull(result.getList());
    }

    /**
    * 读取JSON文件测试
    */
    @Test
    public void testReadDataFromJson() throws JsonProcessingException {
        String path = ""; // json File Path
        String json = FileUtil.readString(path, Charset.defaultCharset());
        Collection<Department> departments = departmentService.readDataFromJson(json);
        assertNotNull(departments);
        log.info("{}", departments);
    }

    /**
    * 从JSON文件导入部门测试
    */
    @Test
    public void testImportDataFromJson() throws JsonProcessingException {
        String path = ""; // json File Path
        String json = FileUtil.readString(path, Charset.defaultCharset());
        Collection<Department> departments = departmentService.importDataFromJson(json);
        assertNotNull(departments);
        log.info("{}", departments);
    }

}