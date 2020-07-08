package com.lzpeng.minimal.common.jpa.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Map;

/**
 * @author: Lzpeng
 * 批量操作实体的通用方法
 * RESTful风格下批量删除都有哪些实现方式？https://www.zhihu.com/question/65356825
 */
@Data
@ApiModel("批量操作实体传输对象")
public class BatchModel<T> {

    /**
     * 要删除的实体id数组
     */
    @ApiModelProperty("要删除的实体id数组")
    private String[] delete;

    /**
     * 要更新的 id:实体 Map
     */
    @ApiModelProperty("要更新的 id:实体 Map")
    private Map<String, T> update;

    /**
     * 要新增的数据
     */
    @ApiModelProperty("要新增的实体集合")
    private T[] create;

}
