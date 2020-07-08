package com.lzpeng.minimal.generate.core;

import java.util.Map;

/**
 * @author : Lzpeng
 */
@FunctionalInterface
public interface EntityParser {

    /**
     * 解析实体类, 获得的模板变量可传入模板引擎生成代码
     * @param clazz 实体类
     * @param <T> 实体类
     * @return 模板变量
     */
    <T> Map<String, Object> parser(Class<T> clazz);
}
