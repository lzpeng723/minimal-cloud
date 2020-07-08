package com.lzpeng.minimal.common.jpa.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 左树右表 DTO
 *
 * @author: Lzpeng
 */
@Data
@EqualsAndHashCode(callSuper = true, exclude = {"tree"})
@ToString(callSuper = true, exclude = {"tree"})
public class LeftTreeRightTableDTO<T extends TreeDTO<T>> extends BaseDTO {
    /**
     * 左树节点id
     */
    @ApiModelProperty("树节点id")
    private String treeId;

    /**
     * 左树节点
     */
    @JsonIgnore
    @ApiModelProperty(value = "树节点", hidden = true)
    private T tree;
}
