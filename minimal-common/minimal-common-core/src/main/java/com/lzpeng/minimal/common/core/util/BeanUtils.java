package com.lzpeng.minimal.common.core.util;

import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import org.apache.commons.collections4.CollectionUtils;

import java.lang.reflect.Field;
import java.util.Collection;

/**
 * @author: Lzpeng
 */
public class BeanUtils {

    /**
     * 遍历 bean 中 String 类型字段,若该字段为字符串则设置为 null
     * @param bean 转换前的 bean
     * @return 转换后的bean
     */
    public static Object convertBlankToNull(Object bean){
        Field[] fields = ReflectUtil.getFields(bean.getClass());
        for (Field field : fields) {
            // 如果是子字符串类型
            if (CharSequence.class.isAssignableFrom(field.getType())){
                CharSequence str = (CharSequence) ReflectUtil.getFieldValue(bean, field);
                // 如果是空字符串 或者 undefined 则设置为 null
                if (str != null && StrUtil.isBlankOrUndefined(str)) {
                    ReflectUtil.setFieldValue(bean, field, null);
                }
            } else if (!ClassUtil.isSimpleValueType(field.getType())){
                // 如果不是简单类型
            }
        }
        return bean;
    }
    /**
     * 遍历 bean 中 Collection 类型字段,若该字段为空集合则设置为 null
     * @param bean 转换前的 bean
     * @return 转换后的bean
     */
    public static Object convertEmptyCollectionToNull(Object bean){
        Field[] fields = ReflectUtil.getFields(bean.getClass());
        for (Field field : fields) {
            // 如果是集合类型
            if (Collection.class.isAssignableFrom(field.getType())){
                Collection collection = (Collection) ReflectUtil.getFieldValue(bean, field);
                // 如果是空集合 则设置为 null
                if (CollectionUtils.isEmpty(collection)) {
                    ReflectUtil.setFieldValue(bean, field, null);
                }
            }
        }
        return bean;
    }

}
