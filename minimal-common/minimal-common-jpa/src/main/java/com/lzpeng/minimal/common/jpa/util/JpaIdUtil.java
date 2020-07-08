package com.lzpeng.minimal.common.jpa.util;

import com.lzpeng.minimal.common.core.domain.ProjectInfo;
import com.lzpeng.minimal.common.core.util.RadixNumberUtils;
import com.lzpeng.minimal.common.core.util.StringConstant;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 进制编码解码工具
 * @author: Lzpeng
 */
public class JpaIdUtil {

    /**
     * 类名可能出现的所有字符
     */
    private static final String SIMPLE_CLASS_NAME = StringConstant.KEYBOARD;

    /**
     * 包名可能出现的所有字符
     */
    private static final String PACKAGE_NAME = StringConstant.PACKAGE_NAME;

    /**
     * 编码后的字符
     */
    private static final String DEFAULT_DIGITS = StringConstant.DEFAULT_DIGITS;
    /**
     * 包名与类名分隔字符
     */
    private static final String DELIMITER = StringConstant.DELIMITER;
    /**
     * 实体类必须符合的正则表达式
     */
    private static final String PATTERN = "^" + ProjectInfo.get().getBaseProjectPackage() +".([a-z]+).domain.entity.([A-Z][a-zA-Z]+)$";
    /**
     * 类名模板
     */
    private static final String FORMAT = ProjectInfo.get().getBaseProjectPackage() + ".%s.domain.entity.%s";

    /**
     * 对数字编码
     * @param number 要编码的10进制数字
     * @return 编码后的结果
     */
    private static String encodeNumber(int number){
        return RadixNumberUtils.toString(number, DEFAULT_DIGITS.length(), DEFAULT_DIGITS);
    }
    /**
     * 对数字编码
     * @param number 待编码的数字
     * @return 编码后结果
     */
    private static String encodeNumber(long number){
        return RadixNumberUtils.toString(number, DEFAULT_DIGITS.length(), DEFAULT_DIGITS);
    }
    /**
     * 对数字编码
     * @param number 待编码的数字
     * @return 编码后结果
     */
    private static String encodeNumber(BigInteger number){
        return RadixNumberUtils.toString(number, DEFAULT_DIGITS.length(), DEFAULT_DIGITS);
    }

    /**
     * 对数字编码
     * @param number 待编码的数字
     * @return 编码后结果
     */
    private static String encodeNumber(Number number){
        if (number instanceof BigInteger) {
            return encodeNumber((BigInteger)number);
        }
        return encodeNumber(number.longValue());
    }


    /**
     * 编码实体类
     * @param clazz 实体类 class
     * @return 编码后的结果
     */
    private static String encodeEntityClazz(Class<?> clazz){
        return encodeEntityClazz(clazz.getName());
    }

    /**
     * 编码实体类
     * @param clazzName 实体类全路径
     * @return 编码后的结果
     */
    private static String encodeEntityClazz(String clazzName){
        Matcher matcher = Pattern.compile(PATTERN).matcher(clazzName);
        if (matcher.matches()) {
            // 包名
            String packageName = matcher.group(1);
            // 类名
            String simpleClazzName = matcher.group(2);
            return String.join(DELIMITER, encodePackageName(packageName), encodeClazzName(simpleClazzName));
        } else {
            throw new IllegalArgumentException("实体类名不合法: " + clazzName + ",必须匹配正则表达式: " + PATTERN);
        }
    }
    /**
     * 编码类名
     * @param clazzName 实体类名称
     * @return 编码后的结果
     */
    private static String encodeClazzName(String clazzName) {
        BigInteger num = RadixNumberUtils.parseBigInteger(clazzName, SIMPLE_CLASS_NAME.length(), SIMPLE_CLASS_NAME);
        return RadixNumberUtils.toString(num, DEFAULT_DIGITS.length(), DEFAULT_DIGITS);
    }

    /**
     * 编码包名
     * @param packageName 包路径
     * @return 编码后结果
     */
    private static String encodePackageName(String packageName) {
        BigInteger num = RadixNumberUtils.parseBigInteger(packageName, PACKAGE_NAME.length(), PACKAGE_NAME);
        return RadixNumberUtils.toString(num, DEFAULT_DIGITS.length(), DEFAULT_DIGITS);
    }

    /**
     * 解码类名
     * @param encodeClazzName 解码类全路径
     * @return 解码后结果
     */
    private static String decodeEntityClazz(String encodeClazzName){
        String[] encodes = encodeClazzName.split("\\" + DELIMITER);
        String packageName = decodePackageName(encodes[0]);
        String clazzName = decodeClazzName(encodes[1]);
        return String.format(FORMAT, packageName, clazzName);
    }

    /**
     * 解码类名
     * @param encodeClazzName 类名
     * @return 解码后结果
     */
    private static String decodeClazzName(String encodeClazzName) {
        BigInteger num = RadixNumberUtils.parseBigInteger(encodeClazzName, DEFAULT_DIGITS.length(), DEFAULT_DIGITS);
        return RadixNumberUtils.toString(num, SIMPLE_CLASS_NAME.length(), SIMPLE_CLASS_NAME);
    }

    /**
     * 解码包名
     * @param encodePackageName 包名
     * @return 解码后结果
     */
    private static String decodePackageName(String encodePackageName) {
        BigInteger num = RadixNumberUtils.parseBigInteger(encodePackageName, DEFAULT_DIGITS.length(), DEFAULT_DIGITS);
        return RadixNumberUtils.toString(num, PACKAGE_NAME.length(), PACKAGE_NAME);
    }

    /**
     * 对数字解码
     * @param str 编码后的字符串
     * @return 解码为snowflake雪花id
     */
    private static Number decodeNumber(String str){
        return RadixNumberUtils.parseBigInteger(str, DEFAULT_DIGITS.length(), DEFAULT_DIGITS);
    }

    /**
     * 编码实体Id
     * @param clazz 实体类
     * @param id snowflake雪花id
     * @param <T> 实体类型
     * @return 实体编码后的字符串
     */
    public static <T> String encodeEntityId(Class<T> clazz,Number id){
        String encodeClazzName = encodeEntityClazz(clazz);
        String encodeId = encodeNumber(id);
        return String.join(DELIMITER, encodeClazzName, encodeId);
    }

    /**
     * 解码实体id
     * @param encodeId 编码后的实体id
     * @return 实体类名:snowID
     */
    public static String decodeEntityId(String encodeId){
        String[] encodes = encodeId.split("\\" + DELIMITER);
        String packageName = decodePackageName(encodes[0]);
        String clazzName = decodeClazzName(encodes[1]);
        Number longId = decodeNumber(encodes[2]);
        return String.format(FORMAT, packageName, clazzName) + ":" + longId;
    }

}
