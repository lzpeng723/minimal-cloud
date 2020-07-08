package com.lzpeng.minimal.generate.jpa;

import cn.hutool.core.util.ClassUtil;
import com.lzpeng.minimal.common.core.domain.ProjectInfo;
import com.lzpeng.minimal.common.jpa.domain.entity.BaseEntity;
import com.lzpeng.minimal.common.jpa.domain.entity.LeftTreeRightTableEntity;
import com.lzpeng.minimal.common.jpa.domain.entity.TreeEntity;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @author : Lzpeng
 */
public class JpaEntityParser {

    /**
     * 解析实体类, 获得的模板变量可传入模板引擎生成代码
     *
     * @param clazz 实体类
     * @param <T>   实体类
     * @return 模板变量
     */
    public static <T> Map<String, Object> parser(Class<T> clazz) {
        return buildEntityTemplateMap(clazz);
    }

    /**
     * 解析实体类, 获得的模板变量可传入模板引擎生成代码
     *
     * @param clazz 实体类
     * @param <T>   实体类
     * @return 模板变量
     */
    private static <T> Map<String, Object> buildEntityTemplateMap(Class<T> clazz) {
        final String baseModulePackage = ProjectInfo.get().getBaseModulePackage();
        Map<String, Object> map = new HashMap<>(14);
        map.put("baseProjectPackage", ProjectInfo.get().getBaseProjectPackage());
        map.put("baseModulePackage", baseModulePackage);
        map.put("moduleName", ProjectInfo.get().getModuleName());
        map.put("generateClassName", JpaCodeGenerator.class.getName());
        map.put("fullClassName", clazz.getName());
        map.put("simpleClassName", clazz.getSimpleName());
        map.put("superClassName", clazz.getSuperclass().getSimpleName());
        map.put("entityType", JpaEntityUtil.getEntityType(clazz));
        map.put("chineseClassName", JpaEntityUtil.getChineseClassName(clazz));
        map.put("editPageType", JpaEntityUtil.getEditPageType(clazz));
        if (LeftTreeRightTableEntity.class.isAssignableFrom(clazz)) {
            Class<? extends TreeEntity> leftTreeType = JpaEntityUtil.getLeftTreeType((Class<? extends LeftTreeRightTableEntity>) clazz);
            if (leftTreeType != null) {
                map.put("leftTreeType", leftTreeType);
                map.put("leftTree", buildEntityTemplateMap(leftTreeType));
            }

        }
        List<Map<String, Object>> columnList = new ArrayList<>();
        for (Field field : clazz.getDeclaredFields()) {
            Map<String, Object> columnMap = buildFieldTemplateMap(field);
            if (!CollectionUtils.isEmpty(columnMap)) {
                columnList.add(columnMap);
            }
        }
        map.put("columnList", columnList);
        Package enumPackage = Package.getPackage(baseModulePackage + ".domain.enums");
        map.put("needEnums", enumPackage != null);
        return map;
    }

    /**
     * 构建实体中字段的map
     *
     * @param field 字段
     * @return 模板变量
     */
    private static Map<String, Object> buildFieldTemplateMap(Field field) {
        ApiModelProperty apiModelProperty = field.getDeclaredAnnotation(ApiModelProperty.class);
        if (ClassUtil.isSimpleValueType(field.getType())) {
            // 简单类型时
            if (apiModelProperty != null /*&& !apiModelProperty.hidden()*/) {
                Map<String, Object> columnMap = new HashMap<>(4);
                columnMap.put("fieldType", JpaEntityUtil.getFieldType(field));
                columnMap.put("fieldName", JpaEntityUtil.getFieldName(field));
                columnMap.put("chineseFieldName", JpaEntityUtil.getChineseFieldName(apiModelProperty));
                columnMap.put("apiModelProperty", JpaEntityUtil.getApiModelProperty(apiModelProperty));
                return columnMap;
            }
        } else if (BaseEntity.class.isAssignableFrom(field.getType())) {
            // 其它实体时
            if (apiModelProperty != null/* && !apiModelProperty.hidden()*/) {
                Map<String, Object> columnMap = new HashMap<>(4);
                columnMap.put("fieldType", JpaEntityUtil.getFieldType(field) + "DTO");
                columnMap.put("fieldName", JpaEntityUtil.getFieldName(field));
                columnMap.put("chineseFieldName", JpaEntityUtil.getChineseFieldName(apiModelProperty));
                columnMap.put("apiModelProperty", JpaEntityUtil.getApiModelProperty(apiModelProperty));
                return columnMap;
            }

        }
        return Collections.emptyMap();
    }
}
