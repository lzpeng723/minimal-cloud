package com.lzpeng.minimal.common.jpa.support;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lzpeng.minimal.common.core.annotation.GenerateCode;
import com.lzpeng.minimal.common.core.domain.ColumnDictionary;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:   李志鹏
 * 表中的列信息
 */
@Data
@ApiModel("字段信息")
@ToString(callSuper = true, exclude = {"table"})
public class ColumnInfo implements ColumnDictionary {

    /** 所在的表 */
    @JsonIgnore
    @ApiModelProperty("所在的表")
    private TableInfo tableInfo;

    /** 列名 */
    @ApiModelProperty("字段名")
    private String columnName;

    /** 类型，对应java.sql.Types中的类型 */
    @ApiModelProperty("字段类型")
    private Integer type;

    /** 类型名称 */
    @ApiModelProperty("字段类型")
    private String typeName;

    /** 大小或数据长度 */
    @ApiModelProperty("大小或数据长度")
    private Integer size;

    /** 是否为可空 */
    @ApiModelProperty("是否为可空")
    private Boolean nullable;

    /** 注释 */
    @ApiModelProperty("注释")
    private String comment;

    /** 实体属性名称 */
    @ApiModelProperty("实体属性名称")
    private String fieldName;

    /** 实体属性类型 */
    @ApiModelProperty("实体属性类型")
    private String className;

    /** 实体属性上注解ApiModelProperty的value */
    @ApiModelProperty("实体属性别名")
    private String apiModelProperty;

    /** 前端用什么组件展示 默认el-input*/
    @ApiModelProperty("组件名称")
    private String componentName;


    @ApiModelProperty("取值范围")
    private List<DictValue> dictValues = new ArrayList<>();

}
