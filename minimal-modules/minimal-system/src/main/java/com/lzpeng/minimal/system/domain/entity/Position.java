package com.lzpeng.minimal.system.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lzpeng.minimal.common.core.annotation.Excel;
import com.lzpeng.minimal.common.core.annotation.GenerateCode;
import com.lzpeng.minimal.common.jpa.domain.entity.LeftTreeRightTableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * @author:  Lzpeng
 */
@Data
@Entity
@ApiModel("岗位")
@DynamicInsert
@DynamicUpdate
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@GenerateCode(editPage = GenerateCode.PageType.DIALOG)
public class Position extends LeftTreeRightTableEntity<Department> {

    /**
     * 岗位名称
     */
    @Excel(name = "岗位名称")
    @ApiModelProperty("岗位名称")
    @Column(columnDefinition="varchar(255) COMMENT '岗位名称'")
    private String name;

    /**
     * 岗位编码
     */
    @Excel(name = "岗位编码")
    @ApiModelProperty("岗位编码")
    @Column(columnDefinition="varchar(255) COMMENT '岗位编码'", unique = true)
    private String number;

    /**
     * 一个岗位一定对应一个角色
     * 但是一个角色不一定对应一个岗位,可能属于某用户组
     */
    @JsonIgnore
    @ApiModelProperty("角色")
    @OneToOne(targetEntity = Role.class)
    @JoinColumn(name = "role_id", columnDefinition = "varchar(255) COMMENT '角色id'")
    private Role role;
}
