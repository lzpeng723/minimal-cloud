package com.lzpeng.minimal.system.service;

import cn.hutool.core.io.FileUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.lzpeng.minimal.common.core.response.QueryResult;
import com.lzpeng.minimal.system.domain.entity.Menu;
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
* 权限菜单 业务层单元测试
* @author: JpaCodeGenerator
*/
@Slf4j
@ExtendWith(SpringExtension.class)
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-27 12:07:44", comments = "权限菜单 业务层单元测试")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class MenuServiceTest {

    /**
    * 权限菜单Service
    */
    @Autowired
    private MenuService menuService;

    /**
    * 保存权限菜单测试
    */
    @Test
    public void testSave() {
        Menu menu = new Menu();
        menu = menuService.save(menu);
        assertNotNull(menu.getId());
    }

    /**
    * 删除权限菜单测试
    */
    @Test
    public void testDelete() {
        String id = "{}";
        menuService.delete(id);
    }

    /**
    * 更新权限菜单测试
    */
    @Test
    public void testUpdate() {
        String id = "{}";
        Menu menu = new Menu();
        menu = menuService.update(id, menu);
        assertEquals(menu.getId(), id);
    }

    /**
    * 根据id查询权限菜单测试
    */
    @Test
    public void testFindById() {
        String id = "{}";
        Menu menu = menuService.findById(id);
        assertEquals(menu.getId(), id);
    }

    /**
    * 分页查询权限菜单测试
    */
    @Test
    public void testQuery() {
        Menu menu = new Menu();
        QueryResult<Menu> result = menuService.query(0, 10, menu);
        assertNotNull(result.getList());
    }

    /**
    * 读取JSON文件测试
    */
    @Test
    public void testReadDataFromJson() throws JsonProcessingException {
        String path = ""; // json File Path
        String json = FileUtil.readString(path, Charset.defaultCharset());
        Collection<Menu> menus = menuService.readDataFromJson(json);
        assertNotNull(menus);
        log.info("{}", menus);
    }

    /**
    * 从JSON文件导入权限菜单测试
    */
    @Test
    public void testImportDataFromJson() throws JsonProcessingException {
        String path = ""; // json File Path
        String json = FileUtil.readString(path, Charset.defaultCharset());
        Collection<Menu> menus = menuService.importDataFromJson(json);
        assertNotNull(menus);
        log.info("{}", menus);
    }

}