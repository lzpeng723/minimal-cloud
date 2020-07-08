package com.lzpeng.minimal.common.core.converter;


import com.lzpeng.minimal.common.core.domain.enums.IntEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.lang.NonNull;

/**
 * String 转 枚举
 * @author: Lzpeng
 * @see org.springframework.core.convert.converter.Converter
 * @see org.springframework.core.convert.converter.ConverterFactory
 * @link {https://blog.csdn.net/weixin_41249041/article/details/96764460} Converter MVC 转换参数使用
 */
public class StringToIntEnumConverterFactory<T extends Enum & IntEnum> implements ConverterFactory<String, T> {


    /**
     * int 类型转换公材
     */
    private IntegerToEnumConverterFactory<T> integerToEnumConverterFactory = new IntegerToEnumConverterFactory<>();

    /**
     * String 类型的 Convert
     * @param targetType 要转换成的枚举类型
     * @param <S> 要转换成的枚举类型
     * @return 转换后的枚举
     */
    @Override
    @NonNull
    public <S extends T> Converter<String, S> getConverter(@NonNull Class<S> targetType) {
        return source -> {
            // 如果是数字进入数字转化逻辑
            int intValue = Integer.parseInt(source);
            return integerToEnumConverterFactory.getConverter(targetType).convert(intValue);
        };
    }
}
