package com.lzpeng.minimal.system.repository;

import com.lzpeng.minimal.system.domain.entity.Role;
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
* 角色 数据层单元测试
* @author: Lzpeng
*/
@Slf4j
@ExtendWith(SpringExtension.class)
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-25 2:02:06", comments = "角色 数据层单元测试")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class RoleRepositoryTest {

    /**
    * 角色Repository
    */
    @Autowired
    private RoleRepository roleRepository;

    /**
    * 保存角色测试
    */
    @Test
    public void testSave(){
        Role role = new Role();
        role = roleRepository.save(role);
        assertNotNull(role.getId());
    }

    /**
    * 删除角色测试
    */
    @Test
    public void testDelete(){
        String id = "{}";
        roleRepository.deleteById(id);
    }

    /**
    * 更新角色测试
    */
    @Test
    public void testUpdate(){
        String id = "{}";
        Optional<Role> optional = roleRepository.findById(id);
        optional.ifPresent(role -> {
            role = roleRepository.save(role);
            assertEquals(role.getId(), id);
        });
    }

    /**
    * 查询所有角色测试
    */
    @Test
    public void testFindAll(){
        Page<Role> rolePage = roleRepository.findAll(PageRequest.of(0, 10));
        assertNotNull(rolePage.getContent());
    }

    /**
    * 根据id查询角色测试
    */
    @Test
    public void testFindById(){
        String id = "{}";
        Optional<Role> optional = roleRepository.findById(id);
        Role role = optional.orElse(null);
        assertNotNull(role);
    }
}