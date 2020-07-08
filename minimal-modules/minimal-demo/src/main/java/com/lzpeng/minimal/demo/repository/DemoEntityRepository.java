package com.lzpeng.minimal.demo.repository;

import com.lzpeng.minimal.common.jpa.repository.BaseRepository;
import com.lzpeng.minimal.demo.domain.entity.DemoEntity;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.annotation.Generated;

/**
* 测试实体 数据层
* @author: JpaCodeGenerator
*/
@Api(tags = "测试实体 Entity")
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-7-7 18:31:21", comments = "测试实体 数据层")
public interface DemoEntityRepository extends BaseRepository<DemoEntity> {

    /**
    * 更新测试实体状态
    * @param id 测试实体id
    * @param enabled 测试实体状态
    * @return 更新成功的条数
    */
    @Override
    @Modifying
    @Query("UPDATE DemoEntity t SET t.enabled = :enabled WHERE t.id = :id")
    int updateEnabled(@Param("id") String id, @Param("enabled") Boolean enabled);


}
