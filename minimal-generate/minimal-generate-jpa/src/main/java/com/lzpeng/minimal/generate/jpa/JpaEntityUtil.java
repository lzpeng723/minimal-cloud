package com.lzpeng.minimal.generate.jpa;

import cn.hutool.core.util.TypeUtil;
import com.lzpeng.minimal.common.core.annotation.GenerateCode;
import com.lzpeng.minimal.common.jpa.domain.entity.LeftTreeRightTableEntity;
import com.lzpeng.minimal.common.jpa.domain.entity.TreeEntity;
import com.squareup.javapoet.AnnotationSpec;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

/**
 * @author:   李志鹏
 */
public class JpaEntityUtil {

    /**
     * 实体基类后缀
     */
    private static final String ENTITY_CLASS_SUFFIX = "Entity";


    /**
     * 获取实体类父类的简单名称
     * @param clazz 实体类
     * @return 实体类父类的简单名称
     */
    public static String getSuperSimpleClassName(Class<?> clazz){
        return clazz.getSuperclass().getSimpleName();
    }
    /**
     * 获取实体类型 Base Tree ...
     * @param clazz 实体类
     * @return 实体类类型
     */
    public static String getEntityType(Class<?> clazz){
        String superClassName = getSuperSimpleClassName(clazz);
        int endIndex = superClassName.length() - ENTITY_CLASS_SUFFIX.length();
        return superClassName.substring(0, endIndex);
    }

    /**
     * 获取实体类中文名
     * @param clazz 实体类
     * @return 实体类中文名
     */
    public static String getChineseClassName(Class<?> clazz){
        ApiModel apiModel = clazz.getDeclaredAnnotation(ApiModel.class);
        return apiModel == null ? clazz.getSimpleName() : apiModel.value();
    }

    /**
     * 获取成员变量类型简称
     * @param field 成员变量
     * @return 成员变量类型简称
     */
    public static String getFieldType(Field field){
        return field.getType().getSimpleName();
    }
    /**
     * 获取成员变量名称
     * @param field 成员变量
     * @return 成员变量名称
     */
    public static String getFieldName(Field field){
        return field.getName();
    }
    /**
     * 获取成员变量中文名称
     * @param apiModelProperty 成员变量上的 ApiModelProperty 注解
     * @return 成员变量中文名称
     */
    public static String getChineseFieldName(ApiModelProperty apiModelProperty){
        return apiModelProperty.value();
    }
    /**
     * 获取成员变量上的 ApiModelProperty 注解的代码
     * @param apiModelProperty 成员变量上的 ApiModelProperty 注解
     * @return 成员变量上的 ApiModelProperty 注解的代码
     */
    public static String getApiModelProperty(ApiModelProperty apiModelProperty){
        AnnotationSpec apiModelPropertySpec = AnnotationSpec.get(apiModelProperty);
        return apiModelPropertySpec.toString().replace(ApiModelProperty.class.getPackage().getName()+".", "");
    }


    /**
     * 获取实体类的前端页面是详情页面还是弹出框
     * @param clazz 实体类
     * @param <T> 实体类
     * @return 详情页面或者弹出框
     */
    public static <T> String getEditPageType(Class<T> clazz) {
        GenerateCode generateCode = clazz.getAnnotation(GenerateCode.class);
        GenerateCode.PageType editPage = generateCode != null ? generateCode.editPage() : (GenerateCode.PageType) AnnotationUtils.getDefaultValue(GenerateCode.class, "editPage");
        assert editPage != null;
        return editPage.name().toLowerCase();
    }

    /**
     * 如果是左树右表实体则返回左树类型,否则返回空
     * @param clazz 实体类
     * @param <T> 左树右表实体的子类
     * @return 左树类型
     */
    public static <T extends LeftTreeRightTableEntity> Class<? extends TreeEntity> getLeftTreeType(Class<T> clazz) {
        if (LeftTreeRightTableEntity.class.isAssignableFrom(clazz)) {
            Type type = TypeUtil.getTypeArgument(clazz);
            if (type instanceof Class) {
                return (Class<? extends TreeEntity>) type;
            }
        }
        return null;
    }
}
