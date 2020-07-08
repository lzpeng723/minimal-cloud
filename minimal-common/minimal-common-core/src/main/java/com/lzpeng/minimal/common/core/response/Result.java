package com.lzpeng.minimal.common.core.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Lzpeng
 */
@Data
@NoArgsConstructor
@ApiModel("Rest接口返回结果")
public class Result<T>{
    /**
     * 操作是否成功
     */
    @ApiModelProperty("操作是否成功")
    private boolean success;

    /**
     * 操作代码
     */
    @ApiModelProperty("操作代码")
    private int code;

    /**
     * 提示信息
     */
    @ApiModelProperty("提示信息")
    private String message;

    /**
     * 详细数据
     */
    @ApiModelProperty("详细数据")
    private T data;

    private Result(ResultCode result) {
        this(result, null);
    }

    private Result(ResultCode result, T data) {
        this.message = result.message();
        this.code = result.code();
        this.success = result.success();
        this.data = data;
    }

    static <T> Result<T> create(ResultCode result){
        return new Result<>(result);
    }
    static <T> Result<T> create(ResultCode result, T data){
        return new Result<>(result, data);
    }
}
