package com.lzpeng.minimal.demo.repository;

import com.lzpeng.minimal.demo.domain.entity.DemoEntity;
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
* 测试实体 数据层单元测试
* @author: JpaCodeGenerator
*/
@Slf4j
@ExtendWith(SpringExtension.class)
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-7-7 18:31:21", comments = "测试实体 数据层单元测试")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class DemoEntityRepositoryTest {

    /**
    * 测试实体Repository
    */
    @Autowired
    private DemoEntityRepository demoEntityRepository;

    /**
    * 保存测试实体测试
    */
    @Test
    public void testSave(){
        DemoEntity demoEntity = new DemoEntity();
        demoEntity = demoEntityRepository.save(demoEntity);
        assertNotNull(demoEntity.getId());
    }

    /**
    * 删除测试实体测试
    */
    @Test
    public void testDelete(){
        String id = "{}";
        demoEntityRepository.deleteById(id);
    }

    /**
    * 更新测试实体测试
    */
    @Test
    public void testUpdate(){
        String id = "{}";
        Optional<DemoEntity> optional = demoEntityRepository.findById(id);
        optional.ifPresent(demoEntity -> {
            demoEntity = demoEntityRepository.save(demoEntity);
            assertEquals(demoEntity.getId(), id);
        });
    }

    /**
    * 查询所有测试实体测试
    */
    @Test
    public void testFindAll(){
        Page<DemoEntity> demoEntityPage = demoEntityRepository.findAll(PageRequest.of(0, 10));
        assertNotNull(demoEntityPage.getContent());
    }

    /**
    * 根据id查询测试实体测试
    */
    @Test
    public void testFindById(){
        String id = "{}";
        Optional<DemoEntity> optional = demoEntityRepository.findById(id);
        DemoEntity demoEntity = optional.orElse(null);
        assertNotNull(demoEntity);
    }
}