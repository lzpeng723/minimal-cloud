package com.lzpeng.minimal.system.repository;

import com.lzpeng.minimal.common.jpa.repository.LeftTreeRightTableRepository;
import com.lzpeng.minimal.system.domain.entity.Position;
import com.lzpeng.minimal.system.domain.entity.Department;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.annotation.Generated;

/**
* 岗位 数据层
* @author: Lzpeng
*/
@Api(tags = "岗位 Entity")
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-25 2:02:06", comments = "岗位 数据层")
public interface PositionRepository extends LeftTreeRightTableRepository<Department, Position> {

    /**
    * 更新岗位状态
    * @param id 岗位id
    * @param enabled 岗位状态
    * @return 更新成功的条数
    */
    @Override
    @Modifying
    @Query("UPDATE Position t SET t.enabled = :enabled WHERE t.id = :id")
    int updateEnabled(@Param("id") String id, @Param("enabled") Boolean enabled);


}
