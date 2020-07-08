package com.lzpeng.minimal.demo.domain.entity;

import com.lzpeng.minimal.common.core.annotation.Excel;
import com.lzpeng.minimal.common.core.annotation.GenerateCode;
import com.lzpeng.minimal.common.jpa.domain.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author : Lzpeng
 */
@Data
@Entity
@ApiModel("测试实体")
@DynamicInsert
@DynamicUpdate
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@GenerateCode(editPage = GenerateCode.PageType.DIALOG)
public class DemoEntity extends BaseEntity {

    /**
     * 名称
     */
    @NotBlank
    @Excel(name = "名称")
    @ApiModelProperty("名称")
    @Column(columnDefinition = "varchar(255) COMMENT '名称'")
    private String name;
    /**
     * 编码
     */
    @Size(min = 6, max = 16, message = "编码必须为6-16位之间")
    @ApiModelProperty("编码")
    @Column(columnDefinition = "varchar(255) COMMENT '编码'", unique = true)
    private String number;

}
