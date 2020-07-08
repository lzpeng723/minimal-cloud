package com.lzpeng.minimal.system.repository;

import com.lzpeng.minimal.common.jpa.repository.LeftTreeRightTableRepository;
import com.lzpeng.minimal.system.domain.entity.Role;
import com.lzpeng.minimal.system.domain.entity.Department;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.annotation.Generated;

/**
* 角色 数据层
* @author: Lzpeng
*/
@Api(tags = "角色 Entity")
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-25 2:02:06", comments = "角色 数据层")
public interface RoleRepository extends LeftTreeRightTableRepository<Department, Role> {

    /**
    * 更新角色状态
    * @param id 角色id
    * @param enabled 角色状态
    * @return 更新成功的条数
    */
    @Override
    @Modifying
    @Query("UPDATE Role t SET t.enabled = :enabled WHERE t.id = :id")
    int updateEnabled(@Param("id") String id, @Param("enabled") Boolean enabled);


}
