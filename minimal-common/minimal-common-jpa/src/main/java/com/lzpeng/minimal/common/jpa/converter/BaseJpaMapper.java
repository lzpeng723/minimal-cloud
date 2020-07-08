package com.lzpeng.minimal.common.jpa.converter;

import cn.hutool.extra.spring.SpringUtil;
import com.lzpeng.minimal.common.core.domain.mapper.BaseMapper;
import com.lzpeng.minimal.common.jpa.domain.dto.BaseDTO;
import com.lzpeng.minimal.common.jpa.domain.entity.BaseEntity;
import lombok.SneakyThrows;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Component;

/**
 * @author : Lzpeng
 */
@Component
public class BaseJpaMapper {

    /**
     * 实体转DTO
     *
     * @param entity   实体
     * @param <DTO>    DTO 类型
     * @param <Entity> 实体类型
     * @return DTO
     */
    @SneakyThrows
    public <DTO extends BaseDTO, Entity extends BaseEntity> DTO toDTO(Entity entity) {
        if (entity == null) {
            return null;
        }
        Class<? extends BaseEntity> entityClass = entity.getClass();
        String entityClassSimpleName = entityClass.getSimpleName();
        String mapperClassSimpleName = entityClassSimpleName + "Mapper";
        String dtoPkgName = entityClass.getPackage().getName();
        String mapperClassName = dtoPkgName.substring(0, dtoPkgName.length() - "entity".length()) + "mapper." + mapperClassSimpleName;
        BaseMapper<DTO, Entity> mapper = (BaseMapper<DTO, Entity>) Mappers.getMapper(Class.forName(mapperClassName));
        return mapper.toDTO(entity);
    }

    /**
     * DTO 转实体
     *
     * @param dto      DTO
     * @param <DTO>    DTO类型
     * @param <Entity> 实体类型
     * @return 实体
     */
    @SneakyThrows
    public <DTO extends BaseDTO, Entity extends BaseEntity> Entity toEntity(DTO dto) {
        if (dto == null) {
            return null;
        }
        Class<? extends BaseDTO> dtoClass = dto.getClass();
        String dtoClassSimpleName = dtoClass.getSimpleName();
        String mapperClassSimpleName = dtoClassSimpleName.substring(0, dtoClassSimpleName.length() - "DTO".length()) + "Mapper";
        String dtoPkgName = dtoClass.getPackage().getName();
        String mapperClassName = dtoPkgName.substring(0, dtoPkgName.length() - "dto".length()) + "mapper." + mapperClassSimpleName;
        BaseMapper<DTO, Entity> mapper = (BaseMapper<DTO, Entity>) Mappers.getMapper(Class.forName(mapperClassName));
        return mapper.toEntity(dto);
    }

}
