package com.lzpeng.minimal.system.config;

import com.lzpeng.minimal.system.domain.entity.User;

/**
 * 存储与线程绑定的变量
 * @author: Lzpeng
 */
public class ThreadLocals {

    /**
     * 存储当前线程用户,若不使用此存储会导致内存溢出
     */
    public static final ThreadLocal<User> USER = new ThreadLocal<>();

}
