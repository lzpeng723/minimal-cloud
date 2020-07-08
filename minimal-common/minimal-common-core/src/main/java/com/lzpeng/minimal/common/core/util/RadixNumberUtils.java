package com.lzpeng.minimal.common.core.util;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

import java.math.BigInteger;

/**
 * 进制转换工具
 * @author: Lzpeng
 */
public class RadixNumberUtils {


    /**
     * 默认进制转换字符
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
     * 转为任意进制，不受jdk最大36的限制
     * @param num 10进制数字
     * @param radix 要转换为的进制数
     * @param digits radix进制数中包含的字符
     * @return 转换后的结果
     */
    public static String toString(long num, int radix, String digits) {
        digits = StrUtil.isBlank(digits) ? DEFAULT_DIGITS : digits;
        Assert.isFalse(StrUtil.length(digits) == 1, "digits 的字符数量不能为 1");
        Assert.isFalse(radix < Character.MIN_RADIX || radix > digits.length(), "错误的进制 {}, 支持的进制范围为 {} 至 {}", radix, Character.MIN_RADIX, digits.length());
        if (radix == TEN_RADIX) {
            return String.valueOf(num);
        }
        char[] buf = new char[65];
        int charPos = 64;
        boolean negative = (num < 0);

        if (!negative) {
            num = -num;
        }

        while (num <= -radix) {
            buf[charPos--] = digits.charAt((int) (-(num % radix)));
            num = num / radix;
        }
        buf[charPos] = digits.charAt((int) (-num));

        if (negative) {
            buf[--charPos] = NEGATIVE;
        }

        return new String(buf, charPos, (65 - charPos));
    }

    /**
     * 转为任意进制，不受jdk最大36的限制
     * @param num 10进制数字
     * @param radix 要转换为的进制数
     * @param digits radix进制数中包含的字符
     * @return 转换后的结果
     */
    public static String toString(int num, int radix, String digits) {
        digits = StrUtil.isBlank(digits) ? DEFAULT_DIGITS : digits;
        Assert.isFalse(StrUtil.length(digits) == 1, "digits 的字符数量不能为 1");
        Assert.isFalse(radix < Character.MIN_RADIX || radix > digits.length(), "错误的进制 {}, 支持的进制范围为 {} 至 {}", radix, Character.MIN_RADIX, digits.length());
        if (radix == TEN_RADIX) {
            return String.valueOf(num);
        }
        char[] buf = new char[65];
        int charPos = 64;
        boolean negative = (num < 0);
        if (!negative) {
            num = -num;
        }
        while (num <= -radix) {
            buf[charPos--] = digits.charAt(-(num % radix));
            num = num / radix;
        }
        buf[charPos] = digits.charAt(-num);
        if (negative) {
            buf[--charPos] = NEGATIVE;
        }
        return new String(buf, charPos, (65 - charPos));
    }

    /**
     * 转为任意进制，不受jdk最大36的限制
     * @param num 10进制数字
     * @param radix 要转换为的进制数
     * @param digits radix进制数中包含的字符
     * @return 转换后的结果
     */
    public static String toString(BigInteger num, int radix, String digits){
        digits = StrUtil.isBlank(digits) ? DEFAULT_DIGITS : digits;
        Assert.isFalse(StrUtil.length(digits) == 1, "digits 的字符数量不能为 1");
        Assert.isFalse(radix < Character.MIN_RADIX || radix > digits.length(), "错误的进制 {}, 支持的进制范围为 {} 至 {}", radix, Character.MIN_RADIX, digits.length());
        return BigIntegerUtils.toString(num, radix, digits);
    }

    /**
     * 任意进制转为10进制
     * @param str radix进制数字的字符串
     * @param radix 进制数
     * @param digits radix进制数中包含的字符
     * @return 10进制数字
     */
    public static int parseInt(String str, int radix, String digits) {
        digits = StrUtil.isBlank(digits) ? DEFAULT_DIGITS : digits;
        Assert.isFalse(StrUtil.length(digits) == 1, "digits 的字符数量不能为 1");
        Assert.isFalse(radix < Character.MIN_RADIX || radix > digits.length(), "错误的进制 {}, 支持的进制范围为 {} 至 {}", radix, Character.MIN_RADIX, digits.length());
        Assert.notBlank(str, "传入的数字为空");
        int result = 0;
        boolean negative = false;
        int i = 0, len = str.length();
        int limit = -Integer.MAX_VALUE;
        char firstChar = str.charAt(0);
        // Possible leading "+" or "-"
        if (digits.indexOf(firstChar) < 0) {
            if (firstChar == NEGATIVE) {
                negative = true;
                limit = Integer.MIN_VALUE;
            } else {
                Assert.isFalse(firstChar == '+', "\"{}\" 中的 {} 是不合法字符", str, firstChar);
            }
            Assert.isFalse(len == 1, "\"{}\" 是不合法字符串,不能仅包含 '+' 或者 '-'", str);
            i++;
        }
        int multmin = limit / radix;
        while (i < len) {
            // Accumulating negatively avoids surprises near MAX_VALUE
            char ch = str.charAt(i++);
            int digit = digits.indexOf(ch);
            Assert.isTrue(digit >= 0 && digit < radix, "\"{}\" 中的 {} 是不合法字符", str, ch);
            Assert.isTrue(result > multmin, "{} 进制数字 \"{}\" 已超过 Integer 可存储的最大数字 {}", radix, str, Integer.MAX_VALUE);
            result *= radix;
            Assert.isTrue(result > limit + digit, "{} 进制数字 \"{}\" 已超过 Integer 可存储的最大数字 {}", radix, str, Integer.MAX_VALUE);
            result -= digit;
        }
        return negative ? result : -result;
    }

    /**
     * 任意进制转为10进制
     * @param str radix进制数字的字符串
     * @param radix 进制数
     * @param digits radix进制数中包含的字符
     * @return 10进制数字
     */
    public static long parseLong(String str, int radix, String digits) {
        digits = StrUtil.isBlank(digits) ? DEFAULT_DIGITS : digits;
        Assert.isFalse(StrUtil.length(digits) == 1, "digits 的字符数量不能为 1");
        Assert.isFalse(radix < Character.MIN_RADIX || radix > digits.length(), "错误的进制 {}, 支持的进制范围为 {} 至 {}", radix, Character.MIN_RADIX, digits.length());
        Assert.notBlank(str, "传入的数字为空");
        long result = 0;
        boolean negative = false;
        int i = 0, len = str.length();
        long limit = -Long.MAX_VALUE;
        char firstChar = str.charAt(0);
        if (digits.indexOf(firstChar) < 0) {
            // Possible leading "+" or "-"
            if (firstChar == NEGATIVE) {
                negative = true;
                limit = Long.MIN_VALUE;
            } else {
                Assert.isFalse(firstChar == '+', "\"{}\" 中的 {} 是不合法字符", str, firstChar);
            }
            Assert.isFalse(len == 1, "\"{}\" 是不合法字符串,不能仅包含 '+' 或者 '-'", str);
            i++;
        }
        long multmin = limit / radix;
        while (i < len) {
            // Accumulating negatively avoids surprises near MAX_VALUE
            char ch = str.charAt(i++);
            int digit = digits.indexOf(ch);
            Assert.isTrue(digit >= 0 && digit < radix, "\"{}\" 中的 {} 是不合法字符", str, ch);
            Assert.isTrue(result > multmin, "{} 进制数字 \"{}\" 已超过 Long 可存储的最大数字 {}", radix, str, Long.MAX_VALUE);
            result *= radix;
            Assert.isTrue(result > limit + digit, "{} 进制数字 \"{}\" 已超过 Long 可存储的最大数字 {}", radix, str, Long.MAX_VALUE);
            result -= digit;

        }
        return negative ? result : -result;
    }

    /**
     * 任意进制转为 10 进制
     * @param str radix进制数字的字符串
     * @param radix 进制数
     * @param digits radix进制数中包含的字符
     * @return 10进制数字
     */
    public static BigInteger parseBigInteger(String str, int radix, String digits){
        digits = StrUtil.isBlank(digits) ? DEFAULT_DIGITS : digits;
        Assert.isFalse(StrUtil.length(digits) == 1, "digits 的字符数量不能为 1");
        Assert.isFalse(radix < Character.MIN_RADIX || radix > digits.length(), "错误的进制 {}, 支持的进制范围为 {} 至 {}", radix, Character.MIN_RADIX, digits.length());
        return BigIntegerUtils.valueOf(str, radix, digits);
    }



}
