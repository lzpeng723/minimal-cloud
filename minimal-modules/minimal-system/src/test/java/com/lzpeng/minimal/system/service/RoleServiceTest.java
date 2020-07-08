package com.lzpeng.minimal.system.service;

import cn.hutool.core.io.FileUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.lzpeng.minimal.common.core.response.QueryResult;
import com.lzpeng.minimal.system.domain.entity.Role;
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
* 角色 业务层单元测试
* @author: JpaCodeGenerator
*/
@Slf4j
@ExtendWith(SpringExtension.class)
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-27 12:07:44", comments = "角色 业务层单元测试")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class RoleServiceTest {

    /**
    * 角色Service
    */
    @Autowired
    private RoleService roleService;

    /**
    * 保存角色测试
    */
    @Test
    public void testSave() {
        Role role = new Role();
        role = roleService.save(role);
        assertNotNull(role.getId());
    }

    /**
    * 删除角色测试
    */
    @Test
    public void testDelete() {
        String id = "{}";
        roleService.delete(id);
    }

    /**
    * 更新角色测试
    */
    @Test
    public void testUpdate() {
        String id = "{}";
        Role role = new Role();
        role = roleService.update(id, role);
        assertEquals(role.getId(), id);
    }

    /**
    * 根据id查询角色测试
    */
    @Test
    public void testFindById() {
        String id = "{}";
        Role role = roleService.findById(id);
        assertEquals(role.getId(), id);
    }

    /**
    * 分页查询角色测试
    */
    @Test
    public void testQuery() {
        Role role = new Role();
        QueryResult<Role> result = roleService.query(0, 10, role);
        assertNotNull(result.getList());
    }

    /**
    * 读取JSON文件测试
    */
    @Test
    public void testReadDataFromJson() throws JsonProcessingException {
        String path = ""; // json File Path
        String json = FileUtil.readString(path, Charset.defaultCharset());
        Collection<Role> roles = roleService.readDataFromJson(json);
        assertNotNull(roles);
        log.info("{}", roles);
    }

    /**
    * 从JSON文件导入角色测试
    */
    @Test
    public void testImportDataFromJson() throws JsonProcessingException {
        String path = ""; // json File Path
        String json = FileUtil.readString(path, Charset.defaultCharset());
        Collection<Role> roles = roleService.importDataFromJson(json);
        assertNotNull(roles);
        log.info("{}", roles);
    }

}