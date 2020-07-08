package com.lzpeng.minimal.common.jpa.annotation;

import java.lang.annotation.Annotation;

/**
 * @date: 2020/3/19
 * @time: 12:59
 * @author: Lzpeng
 * BooleanValue 默认值
 */
public class DefaultBooleanValue implements BooleanValue {
    @Override
    public String trueValue() {
        return "是";
    }

    @Override
    public String falseValue() {
        return "否";
    }

    @Override
    public boolean defaultValue() {
        return false;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return BooleanValue.class;
    }
}
