package com.lzpeng.minimal.common.jpa.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lzpeng.minimal.common.core.annotation.Excel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Base DTO
 *
 * @author: Lzpeng
 */
@Data
public class BaseDTO implements Serializable {

    /**
     * 序列化id
     */
    protected static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID", hidden = true)
    private String id;

    @Excel(name = "是否禁用")
    @ApiModelProperty(value = "是否禁用")
    private Boolean enabled;
    /**
     * 创建时间
     */
    @Excel(name = "创建时间", imported = false)
    @ApiModelProperty(value = "创建时间", hidden = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    /**
     * 最后修改时间
     */
    @Excel(name = "最后修改时间", imported = false)
    @ApiModelProperty(value = "最后修改时间", hidden = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
    /**
     * 创建者
     */
    @Excel(name = "创建者", imported = false)
    @ApiModelProperty(value = "创建者", hidden = true)
    private String createBy;

    /**
     * 最后修改者
     */
    @Excel(name = "最后修改者", imported = false)
    @ApiModelProperty(value = "最后修改者", hidden = true)
    private String updateBy;

    @ApiModelProperty(value = "版本号", hidden = true)
    private Long version;

    @Excel(name = "备注")
    @ApiModelProperty(value = "备注", hidden = true)
    private String remark;


}
