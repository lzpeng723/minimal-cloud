package com.lzpeng.minimal.common.core.response;

/**
 * 构建返回值工具
 * @author: Lzpeng
 */
public class ResultUtil {

    private static Result<?> SUCCESS = Result.create(CommonCode.SUCCESS);

    private static Result<?> FAIL = Result.create(CommonCode.FAIL);

    public static <T> Result<T> success(){
        return (Result<T>) SUCCESS;
    }

    public static <T> Result<T> fail(){
        return (Result<T>) FAIL;
    }
    public static <T> Result<T> fail(T data){
        return Result.create(CommonCode.FAIL, data);
    }

    public static <T> Result<T> success(T data){
        return Result.create(CommonCode.SUCCESS, data);
    }

    public static <T> Result<T> create(ResultCode result, T data){
        return Result.create(result, data);
    }
}
