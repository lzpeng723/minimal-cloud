package com.lzpeng.minimal.system.domain.dto;

import com.lzpeng.minimal.common.jpa.domain.dto.LeftTreeRightTableDTO;
import com.lzpeng.minimal.system.domain.enums.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.annotation.Generated;
import java.util.*;

/**
* AbstractPositionDTO
* @author: JpaCodeGenerator
*/
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-27 12:41:50", comments = "AbstractPositionDTO")
public class AbstractPositionDTO extends LeftTreeRightTableDTO{

    /**
    * 岗位名称
    */
    @ApiModelProperty("岗位名称")
    private String name;
    /**
    * 岗位编码
    */
    @ApiModelProperty("岗位编码")
    private String number;
    /**
    * 角色
    */
    @ApiModelProperty("角色")
    private RoleDTO role;

}
