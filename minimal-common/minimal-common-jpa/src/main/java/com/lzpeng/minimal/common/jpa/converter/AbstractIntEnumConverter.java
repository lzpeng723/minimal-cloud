package com.lzpeng.minimal.common.jpa.converter;


import com.lzpeng.minimal.common.core.domain.enums.IntEnum;

/**
 * 抽象 Integer 类型枚举转换器
 *
 * @param <ATTR> 枚举类型
 * @author: Lzpeng
 * @see javax.persistence.AttributeConverter
 */
public abstract class AbstractIntEnumConverter<ATTR extends Enum & IntEnum> extends BaseEnumConverter<ATTR, Integer> {

}
