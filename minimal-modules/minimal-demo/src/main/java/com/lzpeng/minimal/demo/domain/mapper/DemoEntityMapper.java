package com.lzpeng.minimal.demo.domain.mapper;

import com.lzpeng.minimal.common.core.domain.mapper.BaseMapper;
import com.lzpeng.minimal.common.jpa.converter.BaseJpaMapper;
import com.lzpeng.minimal.demo.domain.dto.DemoEntityDTO;
import com.lzpeng.minimal.demo.domain.entity.DemoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import javax.annotation.Generated;

/**
* 测试实体Mapper: DTO Entity 转换器
* @author: JpaCodeGenerator
*/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = BaseJpaMapper.class)
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-7-7 18:31:21", comments = "测试实体Mapper: DTO Entity 转换器")
public interface DemoEntityMapper extends BaseMapper<DemoEntityDTO, DemoEntity> {
}
