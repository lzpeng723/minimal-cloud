package com.lzpeng.minimal.system.domain.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import com.lzpeng.minimal.common.jpa.converter.AbstractIntEnumConverter;
import com.lzpeng.minimal.common.core.domain.enums.IntEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 菜单类型
 * @author:   Lzpeng
 */
@Getter
@AllArgsConstructor
public enum MenuType implements IntEnum {
    /**
     * 菜单组
     */
    CONTENT(0, "目录"),
    /**
     * 菜单项
     */
    MENU(1, "菜单"),
    /**
     * 功能
     */
    FUNCTION(2, "功能");

    @JsonValue
    private Integer code;
    private String message;

    public static class Converter extends AbstractIntEnumConverter<MenuType> {}
}
