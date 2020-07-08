package com.lzpeng.minimal.samplejpa.domain.mapper;

import com.lzpeng.minimal.common.core.domain.mapper.BaseMapper;
import com.lzpeng.minimal.common.jpa.converter.BaseJpaMapper;
import com.lzpeng.minimal.samplejpa.domain.dto.SampleEntityDTO;
import com.lzpeng.minimal.samplejpa.domain.entity.SampleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import javax.annotation.Generated;

/**
* 示例实体Mapper: DTO Entity 转换器
* @author: JpaCodeGenerator
*/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = BaseJpaMapper.class)
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-28 20:50:57", comments = "示例实体Mapper: DTO Entity 转换器")
public interface SampleEntityMapper extends BaseMapper<SampleEntityDTO, SampleEntity> {
}
