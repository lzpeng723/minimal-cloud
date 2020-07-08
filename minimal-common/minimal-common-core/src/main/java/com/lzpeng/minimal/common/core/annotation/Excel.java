package com.lzpeng.minimal.common.core.annotation;

import java.lang.annotation.*;

/**
 * 导出Excel使用此注解
 * @author: Lzpeng
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Excel {

    /**
     * @return 是否导入此属性
     */
    boolean imported() default true;

    /**
     * @return 是否导出此属性
     */
    boolean exported() default true;

    /**
     * @return 属性导入导出时的列名
     */
    String name();

    /**
     * @return 属性为空时默认导出内容
     */
    String defaultValue() default "";
}
