package com.lzpeng.minimal.common.core.util;

import cn.hutool.core.util.StrUtil;

import java.math.BigInteger;

/**
 * BigInteger 进制转换工具
 * @author: Lzpeng
 */
public class BigIntegerUtils {

    /**
     *  初始化 62 进制数据，索引位置代表字符的数值，比如 A代表10，z代表61等
     */
    private static final String DEFAULT_DIGITS = StringConstant.DEFAULT_DIGITS;

    /**
     *  默认 10 进制
     */
    private static final int TEN_RADIX = 10;

    /**
     * 正数标识
     */
    private static final char POSITIVE = '+';

    /**
     * 负数标识
     */
    private static final char NEGATIVE = '-';


    /**
     * 10 进制 转 任意进制
     * @param num 10进制数字
     * @param radix 要转换为的进制数
     * @param digits radix进制数中包含的字符
     * @return 转换后的结果
     */
    static String toString(BigInteger num, int radix, String digits) {
        return toString(num, BigInteger.valueOf(radix), digits);
    }
    /**
     * 10 进制 转 任意进制
     * @param num 10进制数字
     * @param radix 要转换为的进制数
     * @param digits radix进制数中包含的字符
     * @return 转换后的结果
     */
    private static String toString(BigInteger num, BigInteger radix, String digits) {
        if (radix.compareTo(BigInteger.valueOf(TEN_RADIX)) == 0) {
            return String.valueOf(num);
        }
        boolean negative = (num.signum() < 0);
        if (negative) {
            // 如果是负数, 取其正数部分
            num = num.negate();
        }
        StringBuilder builder = new StringBuilder();
        // 要有等于号,等于的时候是1
        while (num.compareTo(radix) >= 0) {
            builder.append(digits.charAt(num.mod(radix).intValue()));
            num = num.divide(radix);
        }
        builder.append(digits.charAt(num.intValue()));
        if (negative) {
            builder.append('-');
        }
        return builder.reverse().toString();
    }

    /**
     * 任意进制转10进制
     * @param str radix进制数字的字符串
     * @param radix 进制数
     * @param digits radix进制数中包含的字符
     * @return 10进制数字
     */
    static BigInteger valueOf(String str, int radix, String digits) {
        return valueOf(str, BigInteger.valueOf(radix), digits);
    }
    /**
     * 任意进制转10进制
     * @param str radix进制数字的字符串
     * @param radix 进制数
     * @param digits radix进制数中包含的字符
     * @return 10进制数字
     */
    private static BigInteger valueOf(String str, BigInteger radix, String digits) {
        digits = StrUtil.isBlank(digits) ? DEFAULT_DIGITS : digits;
        // 将 0 开头的字符串进行替换
        str = str.replace("^0*", "");
        boolean negative = false;
        char firstChar = str.charAt(0);
        if (firstChar == NEGATIVE){
            negative = true;
            str = str.substring(1);
        } else if (firstChar == POSITIVE){
            str = str.substring(1);
        }
        BigInteger num = BigInteger.ZERO;
        for (int i = 0; i < str.length(); i++) {
            int index = digits.indexOf(str.charAt(i));
            BigInteger bigIndex = BigInteger.valueOf(index);
            BigInteger temp = radix.pow(str.length() - i - 1);
            num = num.add(bigIndex.multiply(temp));
        }
        return negative ? num.negate() : num;
    }

}
