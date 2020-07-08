package com.lzpeng.minimal.samplejpa.repository;

import com.lzpeng.minimal.samplejpa.domain.entity.SampleEntity;
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
* 示例实体 数据层单元测试
* @author: JpaCodeGenerator
*/
@Slf4j
@ExtendWith(SpringExtension.class)
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-28 20:50:57", comments = "示例实体 数据层单元测试")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class SampleEntityRepositoryTest {

    /**
    * 示例实体Repository
    */
    @Autowired
    private SampleEntityRepository sampleEntityRepository;

    /**
    * 保存示例实体测试
    */
    @Test
    public void testSave(){
        SampleEntity sampleEntity = new SampleEntity();
        sampleEntity = sampleEntityRepository.save(sampleEntity);
        assertNotNull(sampleEntity.getId());
    }

    /**
    * 删除示例实体测试
    */
    @Test
    public void testDelete(){
        String id = "{}";
        sampleEntityRepository.deleteById(id);
    }

    /**
    * 更新示例实体测试
    */
    @Test
    public void testUpdate(){
        String id = "{}";
        Optional<SampleEntity> optional = sampleEntityRepository.findById(id);
        optional.ifPresent(sampleEntity -> {
            sampleEntity = sampleEntityRepository.save(sampleEntity);
            assertEquals(sampleEntity.getId(), id);
        });
    }

    /**
    * 查询所有示例实体测试
    */
    @Test
    public void testFindAll(){
        Page<SampleEntity> sampleEntityPage = sampleEntityRepository.findAll(PageRequest.of(0, 10));
        assertNotNull(sampleEntityPage.getContent());
    }

    /**
    * 根据id查询示例实体测试
    */
    @Test
    public void testFindById(){
        String id = "{}";
        Optional<SampleEntity> optional = sampleEntityRepository.findById(id);
        SampleEntity sampleEntity = optional.orElse(null);
        assertNotNull(sampleEntity);
    }
}