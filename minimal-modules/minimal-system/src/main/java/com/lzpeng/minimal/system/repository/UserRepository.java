package com.lzpeng.minimal.system.repository;

import com.lzpeng.minimal.common.jpa.repository.LeftTreeRightTableRepository;
import com.lzpeng.minimal.system.domain.entity.User;
import com.lzpeng.minimal.system.domain.entity.Department;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.annotation.Generated;

/**
* 用户 数据层
* @author: Lzpeng
*/
@Api(tags = "用户 Entity")
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-25 2:02:06", comments = "用户 数据层")
public interface UserRepository extends LeftTreeRightTableRepository<Department, User> {

    /**
    * 更新用户状态
    * @param id 用户id
    * @param enabled 用户状态
    * @return 更新成功的条数
    */
    @Override
    @Modifying
    @Query("UPDATE User t SET t.enabled = :enabled WHERE t.id = :id")
    int updateEnabled(@Param("id") String id, @Param("enabled") Boolean enabled);


}
