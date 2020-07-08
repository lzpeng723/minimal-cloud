package com.lzpeng.minimal.common.jpa.support;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lzpeng.minimal.common.core.domain.ValueDictionary;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;

/**
 * @author:   李志鹏
 * 字典类型
 */
@Data
@ApiModel("字典信息")
public class DictValue implements ValueDictionary {

    /** 哪个列使用 */
    @JsonIgnore
    @ApiModelProperty("列信息")
    private ColumnInfo columnInfo;
    /**
     * 数据库中存什么值
     */
    @ApiModelProperty("数据库中存的值")
    private Integer key;

    /**
     * 前端展示什么值
     */
    @ApiModelProperty("前端展示的值")
    private String value;

    /**
     * 顺序
     */
    @ApiModelProperty("顺序号")
    private Integer orderNum;

    /**
     * 是否默认
     */
    @ApiModelProperty("是否默认")
    private Boolean defaulted;

}
