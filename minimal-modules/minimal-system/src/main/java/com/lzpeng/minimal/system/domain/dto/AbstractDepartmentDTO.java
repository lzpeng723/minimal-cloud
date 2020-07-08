package com.lzpeng.minimal.system.domain.dto;

import com.lzpeng.minimal.common.jpa.domain.dto.TreeDTO;
import com.lzpeng.minimal.system.domain.enums.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.annotation.Generated;
import java.util.*;

/**
* AbstractDepartmentDTO
* @author: JpaCodeGenerator
*/
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-27 12:41:50", comments = "AbstractDepartmentDTO")
public class AbstractDepartmentDTO extends TreeDTO{

    /**
    * 部门名称
    */
    @ApiModelProperty("部门名称")
    private String name;
    /**
    * 部门编码
    */
    @ApiModelProperty("部门编码")
    private String number;

}
