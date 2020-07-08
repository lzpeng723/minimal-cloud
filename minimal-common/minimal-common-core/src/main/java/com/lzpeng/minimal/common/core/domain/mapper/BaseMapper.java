package com.lzpeng.minimal.common.core.domain.mapper;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * mapStruct DTO Entity 转换
 * @author : Lzpeng
 */
public interface BaseMapper<DTO, Entity> {

    /**
     * DTO转Entity
     * @param dto DTO
     * @return Entity
     */
    @InheritConfiguration
    Entity toEntity(DTO dto);

    /**
     * Entity转DTO
     * @param entity Entity
     * @return DTO
     */
    @InheritInverseConfiguration
    DTO toDTO(Entity entity);

    /**
     * DTO集合转Entity集合
     * @param dtoList DTO集合
     * @return Entity集合
     */
    @InheritConfiguration
    List <Entity> toEntity(List<DTO> dtoList);

    /**
     * Entity集合转DTO集合
     * @param entityList Entity集合
     * @return DTO集合
     */
    @InheritInverseConfiguration
    List <DTO> toDTO(List<Entity> entityList);
}
