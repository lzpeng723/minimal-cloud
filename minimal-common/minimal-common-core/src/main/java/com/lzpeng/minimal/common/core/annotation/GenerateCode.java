package com.lzpeng.minimal.common.core.annotation;


import java.lang.annotation.*;

/**
 * 控制实体代码是否生成
 * @author:   Lzpeng
 * */
@Documented
@Target({ElementType.PACKAGE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface GenerateCode {

    /**
     * @return 是否生成代码
     */
    boolean generate() default true;

    /**
     * @return 编辑页面样式 默认 详情页面 可选Dialog页面
     */
    PageType editPage() default PageType.DETAIL;

    enum PageType {
        /**
         * 详情页面打开
         */
        DETAIL,
        /**
         * 弹出框方式打开
         */
        DIALOG;
    }


}
