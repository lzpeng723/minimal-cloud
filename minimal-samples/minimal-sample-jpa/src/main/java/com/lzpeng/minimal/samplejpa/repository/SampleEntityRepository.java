package com.lzpeng.minimal.samplejpa.repository;

import com.lzpeng.minimal.common.jpa.repository.BaseRepository;
import com.lzpeng.minimal.samplejpa.domain.entity.SampleEntity;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.annotation.Generated;

/**
* 示例实体 数据层
* @author: JpaCodeGenerator
*/
@Api(tags = "示例实体 Entity")
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-28 20:50:57", comments = "示例实体 数据层")
public interface SampleEntityRepository extends BaseRepository<SampleEntity> {

    /**
    * 更新示例实体状态
    * @param id 示例实体id
    * @param enabled 示例实体状态
    * @return 更新成功的条数
    */
    @Override
    @Modifying
    @Query("UPDATE SampleEntity t SET t.enabled = :enabled WHERE t.id = :id")
    int updateEnabled(@Param("id") String id, @Param("enabled") Boolean enabled);


}
