package com.lzpeng.minimal.system.repository;

import com.lzpeng.minimal.system.domain.entity.Department;
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
* 部门 数据层单元测试
* @author: Lzpeng
*/
@Slf4j
@ExtendWith(SpringExtension.class)
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-25 2:02:06", comments = "部门 数据层单元测试")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class DepartmentRepositoryTest {

    /**
    * 部门Repository
    */
    @Autowired
    private DepartmentRepository departmentRepository;

    /**
    * 保存部门测试
    */
    @Test
    public void testSave(){
        Department department = new Department();
        department = departmentRepository.save(department);
        assertNotNull(department.getId());
    }

    /**
    * 删除部门测试
    */
    @Test
    public void testDelete(){
        String id = "{}";
        departmentRepository.deleteById(id);
    }

    /**
    * 更新部门测试
    */
    @Test
    public void testUpdate(){
        String id = "{}";
        Optional<Department> optional = departmentRepository.findById(id);
        optional.ifPresent(department -> {
            department = departmentRepository.save(department);
            assertEquals(department.getId(), id);
        });
    }

    /**
    * 查询所有部门测试
    */
    @Test
    public void testFindAll(){
        Page<Department> departmentPage = departmentRepository.findAll(PageRequest.of(0, 10));
        assertNotNull(departmentPage.getContent());
    }

    /**
    * 根据id查询部门测试
    */
    @Test
    public void testFindById(){
        String id = "{}";
        Optional<Department> optional = departmentRepository.findById(id);
        Department department = optional.orElse(null);
        assertNotNull(department);
    }
}