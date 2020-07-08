package com.lzpeng.minimal.common.jpa.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

/**
 * 抽象树形结构DTO
 *
 * @author: Lzpeng
 */
@Data
@EqualsAndHashCode(callSuper = true, exclude = {"parent"})
@ToString(callSuper = true, exclude = {"parent"})
public class TreeDTO<T extends TreeDTO<T>> extends BaseDTO {

    @ApiModelProperty("顺序号")
    private Integer orderNum;

    /**
     * 父节点 Id 不存数据库,接收前台参数使用
     */
    @ApiModelProperty("父节点id")
    private String parentId;


}
