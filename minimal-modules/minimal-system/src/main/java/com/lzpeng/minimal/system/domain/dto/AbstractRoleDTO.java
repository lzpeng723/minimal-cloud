package com.lzpeng.minimal.system.domain.dto;

import com.lzpeng.minimal.common.jpa.domain.dto.LeftTreeRightTableDTO;
import com.lzpeng.minimal.system.domain.enums.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.annotation.Generated;
import java.util.*;

/**
* AbstractRoleDTO
* @author: JpaCodeGenerator
*/
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-27 12:41:50", comments = "AbstractRoleDTO")
public class AbstractRoleDTO extends LeftTreeRightTableDTO{

    /**
    * 角色名称
    */
    @ApiModelProperty("角色名称")
    private String name;
    /**
    * 角色编码
    */
    @ApiModelProperty("角色编码")
    private String number;
    /**
    * 角色介绍
    */
    @ApiModelProperty(example = "一句话说明这个角色能干什么", value = "角色介绍")
    private String description;
    /**
    * 数据权限
    */
    @ApiModelProperty("数据权限")
    private DataScopeType dataScope;
    /**
    * 岗位
    */
    @ApiModelProperty("岗位")
    private PositionDTO position;

}
