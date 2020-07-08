package com.lzpeng.minimal.system.repository;

import com.lzpeng.minimal.common.jpa.repository.TreeRepository;
import com.lzpeng.minimal.system.domain.entity.Department;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.annotation.Generated;

/**
* 部门 数据层
* @author: Lzpeng
*/
@Api(tags = "部门 Entity")
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-25 2:02:06", comments = "部门 数据层")
public interface DepartmentRepository extends TreeRepository<Department> {

    /**
    * 更新部门状态
    * @param id 部门id
    * @param enabled 部门状态
    * @return 更新成功的条数
    */
    @Override
    @Modifying
    @Query("UPDATE Department t SET t.enabled = :enabled WHERE t.id = :id")
    int updateEnabled(@Param("id") String id, @Param("enabled") Boolean enabled);


}
