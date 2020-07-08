package com.lzpeng.minimal.common.core.util;

import cn.hutool.core.lang.caller.CallerUtil;

import java.net.URL;

/**
 * 当前环境信息
 * @author: Lzpeng
 */
public class EnvUtil {

    /**
     * 当前环境是否是开发环境
     * 待检验 war 包部署是否可行
     * @return 是否是开发环境
     */
    public static boolean isDev(){
        Class<?> caller = CallerUtil.getCallerCaller();
        URL url = caller.getClassLoader().getResource(caller.getName().replace(".", "/") + ".class");
        assert url != null;
        return "file".equalsIgnoreCase(url.getProtocol());
    }

    /**
     * 当前环境是否是正式环境
     * 待检验 war 包部署是否可行
     * @return 是否是正式环境
     */
    public static boolean isProd(){
        return !isDev();
    }
}
