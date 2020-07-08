package com.lzpeng.minimal.system.repository;

import com.lzpeng.minimal.system.domain.entity.User;
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
* 用户 数据层单元测试
* @author: Lzpeng
*/
@Slf4j
@ExtendWith(SpringExtension.class)
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-25 2:02:06", comments = "用户 数据层单元测试")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class UserRepositoryTest {

    /**
    * 用户Repository
    */
    @Autowired
    private UserRepository userRepository;

    /**
    * 保存用户测试
    */
    @Test
    public void testSave(){
        User user = new User();
        user = userRepository.save(user);
        assertNotNull(user.getId());
    }

    /**
    * 删除用户测试
    */
    @Test
    public void testDelete(){
        String id = "{}";
        userRepository.deleteById(id);
    }

    /**
    * 更新用户测试
    */
    @Test
    public void testUpdate(){
        String id = "{}";
        Optional<User> optional = userRepository.findById(id);
        optional.ifPresent(user -> {
            user = userRepository.save(user);
            assertEquals(user.getId(), id);
        });
    }

    /**
    * 查询所有用户测试
    */
    @Test
    public void testFindAll(){
        Page<User> userPage = userRepository.findAll(PageRequest.of(0, 10));
        assertNotNull(userPage.getContent());
    }

    /**
    * 根据id查询用户测试
    */
    @Test
    public void testFindById(){
        String id = "{}";
        Optional<User> optional = userRepository.findById(id);
        User user = optional.orElse(null);
        assertNotNull(user);
    }
}