package com.lzpeng.minimal.tool.repository;

import com.lzpeng.minimal.tool.domain.entity.Gen;
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
* 代码生成模板 数据层单元测试
* @author: JpaCodeGenerator
*/
@Slf4j
@ExtendWith(SpringExtension.class)
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-27 23:21:56", comments = "代码生成模板 数据层单元测试")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class GenRepositoryTest {

    /**
    * 代码生成模板Repository
    */
    @Autowired
    private GenRepository genRepository;

    /**
    * 保存代码生成模板测试
    */
    @Test
    public void testSave(){
        Gen gen = new Gen();
        gen = genRepository.save(gen);
        assertNotNull(gen.getId());
    }

    /**
    * 删除代码生成模板测试
    */
    @Test
    public void testDelete(){
        String id = "{}";
        genRepository.deleteById(id);
    }

    /**
    * 更新代码生成模板测试
    */
    @Test
    public void testUpdate(){
        String id = "{}";
        Optional<Gen> optional = genRepository.findById(id);
        optional.ifPresent(gen -> {
            gen = genRepository.save(gen);
            assertEquals(gen.getId(), id);
        });
    }

    /**
    * 查询所有代码生成模板测试
    */
    @Test
    public void testFindAll(){
        Page<Gen> genPage = genRepository.findAll(PageRequest.of(0, 10));
        assertNotNull(genPage.getContent());
    }

    /**
    * 根据id查询代码生成模板测试
    */
    @Test
    public void testFindById(){
        String id = "{}";
        Optional<Gen> optional = genRepository.findById(id);
        Gen gen = optional.orElse(null);
        assertNotNull(gen);
    }
}