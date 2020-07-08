package com.lzpeng.minimal.system.domain.entity;

import com.lzpeng.minimal.common.core.annotation.Excel;
import com.lzpeng.minimal.common.core.annotation.GenerateCode;
import com.lzpeng.minimal.common.jpa.domain.entity.BaseEntity;
import com.lzpeng.minimal.system.domain.enums.NoticeType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;

/**
 * 通知实体
 * @author: Lzpeng
 */
@Data
@Entity
@ApiModel("通知")
@DynamicInsert
@DynamicUpdate
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@GenerateCode(editPage = GenerateCode.PageType.DIALOG)
public class Notice extends BaseEntity {

    /**
     * 通知名称
     */

    @Excel(name = "通知名称")
    @ApiModelProperty("通知名称")
    @Column(columnDefinition = "varchar(255) COMMENT '通知名称'")
    private String name;

    /**
     * 通知编码
     */
    @Excel(name = "通知编码")
    @ApiModelProperty("通知编码")
    @Column(columnDefinition = "varchar(255) COMMENT '通知编码'", unique = true)
    private String number;

    /**
     * 通知正文
     */
    @Excel(name = "通知正文")
    @ApiModelProperty("通知正文")
    @Column(columnDefinition = "text COMMENT '通知正文'")
    private String content;

    /**
     * 通知类型
     */
    @Excel(name = "通知类型")
    @ApiModelProperty("通知类型")
    @Convert(converter = NoticeType.Converter.class)
    @Column(columnDefinition = "int(11) DEFAULT 2 COMMENT '通知类型 0: 顶部滚动通知, 1: 右下角弹出消息, 2:待办, 3:已办'", nullable = false)
    private NoticeType noticeType;

}
