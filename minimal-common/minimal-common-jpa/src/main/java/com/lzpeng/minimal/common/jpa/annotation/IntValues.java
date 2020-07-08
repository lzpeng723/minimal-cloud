package com.lzpeng.minimal.common.jpa.annotation;

import com.lzpeng.minimal.common.core.domain.enums.IntEnum;

import java.lang.annotation.*;

/**
 * 实体字段初始化字典数据集合
 * @author: Lzpeng
 * @deprecated please use com.lzpeng.minimal.common.core.enums.IntEnum
 * @see IntEnum
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Deprecated
public @interface IntValues {

    IntValue[] value();
}
