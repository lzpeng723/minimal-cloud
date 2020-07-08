package com.lzpeng.minimal.tool.repository;

import com.lzpeng.minimal.common.jpa.repository.BaseRepository;
import com.lzpeng.minimal.tool.domain.entity.Gen;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.annotation.Generated;

/**
* 代码生成模板 数据层
* @author: JpaCodeGenerator
*/
@Api(tags = "代码生成模板 Entity")
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-27 23:21:56", comments = "代码生成模板 数据层")
public interface GenRepository extends BaseRepository<Gen> {

    /**
    * 更新代码生成模板状态
    * @param id 代码生成模板id
    * @param enabled 代码生成模板状态
    * @return 更新成功的条数
    */
    @Override
    @Modifying
    @Query("UPDATE Gen t SET t.enabled = :enabled WHERE t.id = :id")
    int updateEnabled(@Param("id") String id, @Param("enabled") Boolean enabled);


}
