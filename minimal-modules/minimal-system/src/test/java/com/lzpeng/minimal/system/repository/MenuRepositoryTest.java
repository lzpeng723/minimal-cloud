package com.lzpeng.minimal.system.repository;

import com.lzpeng.minimal.system.domain.entity.Menu;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Generated;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
* 权限菜单 数据层单元测试
* @author: Lzpeng
*/
@Slf4j
@ExtendWith(SpringExtension.class)
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-25 2:02:06", comments = "权限菜单 数据层单元测试")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class MenuRepositoryTest {

    /**
    * 权限菜单Repository
    */
    @Autowired
    private MenuRepository menuRepository;

    /**
    * 保存权限菜单测试
    */
    @Test
    public void testSave(){
        Menu menu = new Menu();
        menu = menuRepository.save(menu);
        assertNotNull(menu.getId());
    }

    /**
    * 删除权限菜单测试
    */
    @Test
    public void testDelete(){
        String id = "{}";
        menuRepository.deleteById(id);
    }

    /**
    * 更新权限菜单测试
    */
    @Test
    public void testUpdate(){
        String id = "{}";
        Optional<Menu> optional = menuRepository.findById(id);
        optional.ifPresent(menu -> {
            menu = menuRepository.save(menu);
            assertEquals(menu.getId(), id);
        });
    }

    /**
    * 查询所有权限菜单测试
    */
    @Test
    public void testFindAll(){
        Page<Menu> menuPage = menuRepository.findAll(PageRequest.of(0, 10));
        assertNotNull(menuPage.getContent());
    }

    /**
    * 根据id查询权限菜单测试
    */
    @Test
    public void testFindById(){
        String id = "{}";
        Optional<Menu> optional = menuRepository.findById(id);
        Menu menu = optional.orElse(null);
        assertNotNull(menu);
    }
}