package com.lzpeng.minimal.system.repository;

import com.lzpeng.minimal.common.jpa.repository.BaseRepository;
import com.lzpeng.minimal.system.domain.entity.NotificationRecord;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.annotation.Generated;

/**
* 通知记录 数据层
* @author: Lzpeng
*/
@Api(tags = "通知记录 Entity")
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-25 2:02:06", comments = "通知记录 数据层")
public interface NotificationRecordRepository extends BaseRepository<NotificationRecord> {

    /**
    * 更新通知记录状态
    * @param id 通知记录id
    * @param enabled 通知记录状态
    * @return 更新成功的条数
    */
    @Override
    @Modifying
    @Query("UPDATE NotificationRecord t SET t.enabled = :enabled WHERE t.id = :id")
    int updateEnabled(@Param("id") String id, @Param("enabled") Boolean enabled);


}
