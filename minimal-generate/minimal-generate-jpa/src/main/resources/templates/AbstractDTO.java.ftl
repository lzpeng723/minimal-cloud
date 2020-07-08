package ${baseModulePackage}.domain.dto;

import ${baseProjectPackage}.common.jpa.domain.dto.${entityType}DTO;<#if needEnums>
import ${baseModulePackage}.domain.enums.*;</#if>
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.annotation.Generated;
import java.util.*;

/**
* Abstract${simpleClassName}DTO
* @author: ${author!'JpaCodeGenerator'}
*/
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Generated(value = "${generateClassName}", date = "${.now?date} ${.now?time}", comments = "Abstract${simpleClassName}DTO")
public class Abstract${simpleClassName}DTO extends ${entityType}DTO{

<#list columnList as column>
    /**
    * ${column.chineseFieldName}
    */
    ${column.apiModelProperty}
    private ${column.fieldType} ${column.fieldName};
</#list>

}
