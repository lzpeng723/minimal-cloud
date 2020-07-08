package com.lzpeng.minimal.common.jpa.support;


import com.lzpeng.minimal.common.core.domain.TableDictionary;
import com.lzpeng.minimal.common.jpa.domain.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

/**
 * @author:   李志鹏
 * 项目中所用的的表信息
 */
@Data
@ApiModel("表信息")
@EqualsAndHashCode(exclude={"columns"})
public class TableInfo implements TableDictionary {

    /** 表名 */
    @ApiModelProperty("表名")
    private String tableName;

    /** 注释 */
    @ApiModelProperty("表注释")
    private String comment;

    /** 实体类型 */
    @ApiModelProperty("实体类名")
    private String className;

    /** 实体类上注解ApiModel的value */
    @ApiModelProperty("实体类别名")
    private String apiModel;

    @ApiModelProperty("列信息")
    private Set<ColumnInfo> columns = new HashSet<>();

}
