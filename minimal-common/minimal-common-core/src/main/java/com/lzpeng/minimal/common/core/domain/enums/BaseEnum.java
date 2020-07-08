package com.lzpeng.minimal.common.core.domain.enums;

/**
 * 所有枚举的基类
 * @author: Lzpeng
 */
public interface BaseEnum<DB>{

    /**
     * 得到在程序中传输的值
     * @return 在程序中传输的值
     */
    DB getCode();

    /**
     * 得到前端显示的值
     * @return 前端显示的值
     */
    String getMessage();
}

