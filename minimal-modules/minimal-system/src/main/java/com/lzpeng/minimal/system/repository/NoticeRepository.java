package com.lzpeng.minimal.system.repository;

import com.lzpeng.minimal.common.jpa.repository.BaseRepository;
import com.lzpeng.minimal.system.domain.entity.Notice;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.annotation.Generated;

/**
* 通知 数据层
* @author: Lzpeng
*/
@Api(tags = "通知 Entity")
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-25 2:02:06", comments = "通知 数据层")
public interface NoticeRepository extends BaseRepository<Notice> {

    /**
    * 更新通知状态
    * @param id 通知id
    * @param enabled 通知状态
    * @return 更新成功的条数
    */
    @Override
    @Modifying
    @Query("UPDATE Notice t SET t.enabled = :enabled WHERE t.id = :id")
    int updateEnabled(@Param("id") String id, @Param("enabled") Boolean enabled);


}
