package com.lzpeng.minimal.tool.domain.mapper;

import com.lzpeng.minimal.common.core.domain.mapper.BaseMapper;
import com.lzpeng.minimal.common.jpa.converter.BaseJpaMapper;
import com.lzpeng.minimal.tool.domain.dto.GenDTO;
import com.lzpeng.minimal.tool.domain.entity.Gen;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import javax.annotation.Generated;

/**
* 代码生成模板Mapper: DTO Entity 转换器
* @author: JpaCodeGenerator
*/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = BaseJpaMapper.class)
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-27 23:21:56", comments = "代码生成模板Mapper: DTO Entity 转换器")
public interface GenMapper extends BaseMapper<GenDTO, Gen> {
}
