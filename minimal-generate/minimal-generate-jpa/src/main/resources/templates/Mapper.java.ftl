package ${baseModulePackage}.domain.mapper;

import ${baseProjectPackage}.common.core.domain.mapper.BaseMapper;
import ${baseProjectPackage}.common.jpa.converter.BaseJpaMapper;
import ${baseModulePackage}.domain.dto.${simpleClassName}DTO;
import ${fullClassName};
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import javax.annotation.Generated;

/**
* ${chineseClassName}Mapper: DTO Entity 转换器
* @author: ${author!'JpaCodeGenerator'}
*/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = BaseJpaMapper.class)
@Generated(value = "${generateClassName}", date = "${.now?date} ${.now?time}", comments = "${chineseClassName}Mapper: DTO Entity 转换器")
public interface ${simpleClassName}Mapper extends BaseMapper<${simpleClassName}DTO, ${simpleClassName}> {
}
