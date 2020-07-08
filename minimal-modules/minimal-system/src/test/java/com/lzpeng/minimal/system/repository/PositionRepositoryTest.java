package com.lzpeng.minimal.system.repository;

import com.lzpeng.minimal.system.domain.entity.Position;
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
* 岗位 数据层单元测试
* @author: Lzpeng
*/
@Slf4j
@ExtendWith(SpringExtension.class)
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-25 2:02:06", comments = "岗位 数据层单元测试")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class PositionRepositoryTest {

    /**
    * 岗位Repository
    */
    @Autowired
    private PositionRepository positionRepository;

    /**
    * 保存岗位测试
    */
    @Test
    public void testSave(){
        Position position = new Position();
        position = positionRepository.save(position);
        assertNotNull(position.getId());
    }

    /**
    * 删除岗位测试
    */
    @Test
    public void testDelete(){
        String id = "{}";
        positionRepository.deleteById(id);
    }

    /**
    * 更新岗位测试
    */
    @Test
    public void testUpdate(){
        String id = "{}";
        Optional<Position> optional = positionRepository.findById(id);
        optional.ifPresent(position -> {
            position = positionRepository.save(position);
            assertEquals(position.getId(), id);
        });
    }

    /**
    * 查询所有岗位测试
    */
    @Test
    public void testFindAll(){
        Page<Position> positionPage = positionRepository.findAll(PageRequest.of(0, 10));
        assertNotNull(positionPage.getContent());
    }

    /**
    * 根据id查询岗位测试
    */
    @Test
    public void testFindById(){
        String id = "{}";
        Optional<Position> optional = positionRepository.findById(id);
        Position position = optional.orElse(null);
        assertNotNull(position);
    }
}