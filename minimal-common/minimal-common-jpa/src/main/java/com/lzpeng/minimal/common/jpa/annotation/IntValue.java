package com.lzpeng.minimal.common.jpa.annotation;

import com.lzpeng.minimal.common.core.domain.enums.IntEnum;

import java.lang.annotation.*;

/**
 *
 * Repeatable 组合注解
 * @author: Lzpeng
 * @deprecated please use com.lzpeng.minimal.common.core.enums.IntEnum
 * @see IntEnum
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Repeatable(IntValues.class)
@Deprecated
public @interface IntValue {

    /**
     * @return 数据库中存的值
     */
    int key();

    /**
     * @return 前端展示的值
     */
    String value();
}
