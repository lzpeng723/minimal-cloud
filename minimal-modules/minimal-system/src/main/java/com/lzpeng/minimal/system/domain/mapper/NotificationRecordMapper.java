package com.lzpeng.minimal.system.domain.mapper;

import com.lzpeng.minimal.common.core.domain.mapper.BaseMapper;
import com.lzpeng.minimal.common.jpa.converter.BaseJpaMapper;
import com.lzpeng.minimal.system.domain.dto.NotificationRecordDTO;
import com.lzpeng.minimal.system.domain.entity.NotificationRecord;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import javax.annotation.Generated;

/**
* 通知记录Mapper: DTO Entity 转换器
* @author: JpaCodeGenerator
*/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = BaseJpaMapper.class)
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-27 12:42:04", comments = "通知记录Mapper: DTO Entity 转换器")
public interface NotificationRecordMapper extends BaseMapper<NotificationRecordDTO, NotificationRecord> {
}
