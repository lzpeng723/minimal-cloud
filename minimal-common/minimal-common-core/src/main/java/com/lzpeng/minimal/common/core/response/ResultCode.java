package com.lzpeng.minimal.common.core.response;

/**
 * 错误代码信息接口
 * @author: Lzpeng
 */
public interface ResultCode {
    /**
     * 返回操作是否成功,true为成功，false操作失败
     * @return 操作是否成功
     */
    boolean success();

    /**
     * 返回操作码
     * @return 操作代码
     */
    int code();

    /**
     * 返回提示信息
     * @return 提示信息
     */
    String message();

}
