package com.lzpeng.minimal.common.core.converter;


import com.lzpeng.minimal.common.core.domain.enums.IntEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.lang.NonNull;

/**
 * integer 转 枚举
 * @author: Lzpeng
 * @see org.springframework.core.convert.converter.Converter
 * @see org.springframework.core.convert.converter.ConverterFactory
 * @link {https://blog.csdn.net/weixin_41249041/article/details/96764460} Converter MVC 转换参数使用
 */
public class IntegerToEnumConverterFactory<T extends Enum & IntEnum> implements ConverterFactory<Integer, T> {

    /**
     * integer 转为 targetType
     * @param targetType 要转换成的枚举类型
     * @param <S> 要转换成的枚举类型
     * @return 转换后的枚举
     */
    @Override
    @NonNull
    public <S extends T> Converter<Integer, S> getConverter(@NonNull Class<S> targetType) {
        return source -> {
            if (!targetType.isEnum()) {
                throw new UnsupportedOperationException(targetType.getName() + "不是枚举, 请检查");
            }
            S[] enums = targetType.getEnumConstants();
            for (S anEnum : enums) {
                if (anEnum.getCode().equals(source)) {
                    return anEnum;
                }
            }
            throw new UnsupportedOperationException("枚举转化异常。枚举【" + targetType.getName() + "】, mvc传入的值为：【" + source + "】");
        };

    }
}
