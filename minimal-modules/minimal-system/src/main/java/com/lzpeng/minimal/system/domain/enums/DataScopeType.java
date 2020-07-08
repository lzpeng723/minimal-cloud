package com.lzpeng.minimal.system.domain.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import com.lzpeng.minimal.common.jpa.converter.AbstractIntEnumConverter;
import com.lzpeng.minimal.common.core.domain.enums.IntEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author:   Lzpeng
 */
@Getter
@AllArgsConstructor
public enum DataScopeType implements IntEnum {

    /**
     * 仅本人数据权限
     */
    SELF(0, "仅本人数据权限"),
    /**
     * 本部门数据权限
     */
    DEPARTMENT(1, "本部门数据权限"),
    /**
     * 本部门及以下数据权限
     */
    DEPARTMENT_SUB(2, "本部门及以下数据权限"),
    /**
     * 全部数据权限
     */
    ALL(3, "全部数据权限"),
    /**
     * 自定义数据权限
     */
    CUSTOM(4, "自定义数据权限");

    @JsonValue
    private Integer code;
    private String message;

    public static class Converter extends AbstractIntEnumConverter<DataScopeType> {}
}
