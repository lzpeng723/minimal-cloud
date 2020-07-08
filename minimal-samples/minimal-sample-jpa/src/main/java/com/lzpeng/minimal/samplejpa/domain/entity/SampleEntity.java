package com.lzpeng.minimal.samplejpa.domain.entity;

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
 * 示例实体
 * @author : Lzpeng
 */
@Data
@Entity
@ApiModel("示例实体")
@DynamicInsert
@DynamicUpdate
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@GenerateCode(editPage = GenerateCode.PageType.DIALOG)
public class SampleEntity extends BaseEntity {

    /**
     * 非空字段
     */
    @NotBlank
    @Excel(name = "非空字段")
    @ApiModelProperty("非空字段")
    @Column(columnDefinition = "varchar(255) COMMENT '非空字段'", unique = true)
    private String notBlank;
    /**
     * 定长字段
     */
    @Size(min = 6, max = 10, message = "只能为 6~10 位字符")
    @ApiModelProperty("定长字段")
    @Column(columnDefinition = "varchar(255) COMMENT '定长字段'")
    private String fixedLength;
}
