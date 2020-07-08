package com.lzpeng.minimal.common.jpa.converter;

import cn.hutool.core.util.TypeUtil;
import com.lzpeng.minimal.common.core.domain.enums.BaseEnum;

import javax.persistence.AttributeConverter;
import java.lang.reflect.Type;
import java.util.Optional;

/**
 * 枚举转换器
 *
 * @param <ATTR> 枚举类型
 * @param <DB>   数据库字段类型
 * @author: Lzpeng
 * @see javax.persistence.AttributeConverter
 * @link {https://blog.csdn.net/wanping321/article/details/90269057}
 */
public abstract class BaseEnumConverter<ATTR extends Enum & BaseEnum<DB>, DB> implements AttributeConverter<ATTR, DB> {

    /**
     * 将枚举转换为数据库要存储的值
     * @param attribute 枚举值
     * @return 数据库存储的值
     * @link {https://stackoverflow.com/questions/27031244/lambdaconversionexception-with-generics-jvm-bug}
     */
    @Override
    public DB convertToDatabaseColumn(ATTR attribute) {
        Optional<DB> optional = Optional.ofNullable(attribute).map(v -> v.getCode());
        return optional.orElse(null);
    }

    /**
     * 将数据库存储的值转为枚举
     * @param dbData 数据库存储的值
     * @return  枚举
     */
    @Override
    public ATTR convertToEntityAttribute(DB dbData) {
        // 得到真实枚举类型
        Type type = TypeUtil.getTypeArgument(getClass());
        Class<ATTR> clazz = (Class<ATTR>) type;
        if (!clazz.isEnum()) {
            throw new UnsupportedOperationException(clazz.getName() + "不是枚举, 请检查");
        }
        ATTR[] enums = clazz.getEnumConstants();
        for (ATTR anEnum : enums) {
            if (anEnum.getCode().equals(dbData)) {
                return anEnum;
            }
        }
        throw new UnsupportedOperationException("枚举转化异常。枚举【" + clazz.getName() + "】,数据库库中的值为：【" + dbData + "】");
    }

}
