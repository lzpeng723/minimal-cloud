package com.lzpeng.minimal.system.service;

import cn.hutool.core.io.FileUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.lzpeng.minimal.common.core.response.QueryResult;
import com.lzpeng.minimal.system.domain.entity.User;
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
* 用户 业务层单元测试
* @author: JpaCodeGenerator
*/
@Slf4j
@ExtendWith(SpringExtension.class)
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-27 12:07:44", comments = "用户 业务层单元测试")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class UserServiceTest {

    /**
    * 用户Service
    */
    @Autowired
    private UserService userService;

    /**
    * 保存用户测试
    */
    @Test
    public void testSave() {
        User user = new User();
        user = userService.save(user);
        assertNotNull(user.getId());
    }

    /**
    * 删除用户测试
    */
    @Test
    public void testDelete() {
        String id = "{}";
        userService.delete(id);
    }

    /**
    * 更新用户测试
    */
    @Test
    public void testUpdate() {
        String id = "{}";
        User user = new User();
        user = userService.update(id, user);
        assertEquals(user.getId(), id);
    }

    /**
    * 根据id查询用户测试
    */
    @Test
    public void testFindById() {
        String id = "{}";
        User user = userService.findById(id);
        assertEquals(user.getId(), id);
    }

    /**
    * 分页查询用户测试
    */
    @Test
    public void testQuery() {
        User user = new User();
        QueryResult<User> result = userService.query(0, 10, user);
        assertNotNull(result.getList());
    }

    /**
    * 读取JSON文件测试
    */
    @Test
    public void testReadDataFromJson() throws JsonProcessingException {
        String path = ""; // json File Path
        String json = FileUtil.readString(path, Charset.defaultCharset());
        Collection<User> users = userService.readDataFromJson(json);
        assertNotNull(users);
        log.info("{}", users);
    }

    /**
    * 从JSON文件导入用户测试
    */
    @Test
    public void testImportDataFromJson() throws JsonProcessingException {
        String path = ""; // json File Path
        String json = FileUtil.readString(path, Charset.defaultCharset());
        Collection<User> users = userService.importDataFromJson(json);
        assertNotNull(users);
        log.info("{}", users);
    }

}