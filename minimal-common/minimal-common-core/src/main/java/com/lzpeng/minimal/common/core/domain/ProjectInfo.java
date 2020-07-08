package com.lzpeng.minimal.common.core.domain;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.ClassScanner;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.AccessLevel;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 项目信息
 * @author : Lzpeng
 */
@Getter
@ToString
@Builder(access = AccessLevel.PRIVATE)
public class ProjectInfo {

    /**
     * 顶级域名
     */
    private String topName;

    /**
     * 公司名
     */
    private String companyName;

    /**
     * 项目名
     */
    private String projectName;

    /**
     * 模块名
     */
    private String moduleName;


    /**
     * 当前模块信息
     */
    private static ProjectInfo projectInfo;


    /**
     * 获取当前项目根包路径
     * @return 当前项目根包路径
     */
    public String getBaseProjectPackage(){
        return String.join(".", topName, companyName, projectName);
    }

    /**
     * 获取当前模块根包路径
     * @return 当前模块根包路径
     */
    public String getBaseModulePackage(){
        return String.join(".", topName, companyName, projectName, moduleName);
    }

    /**
     * 获得当前模块信息
     * @return 当前模块信息
     */
    public static ProjectInfo get(){
        if (projectInfo != null) {
            return projectInfo;
        }
        Class<?> mainClass = getSpringBootApplicationClass();
        return projectInfo = get(mainClass);
    }

    /**
     * 从 指定的类 构建项目信息
     * @param mainClass 指定的类
     * @return 项目信息
     */
    public static ProjectInfo get(Class<?> mainClass){
        // 包名
        String packageName = mainClass.getPackage().getName();
        // 包名分割
        String[] pkgNames = packageName.split("\\.");
        int length = pkgNames.length;
        // 从后向前读取
        return ProjectInfo.builder()
                .moduleName(pkgNames[--length])
                .projectName(pkgNames[--length])
                .companyName(pkgNames[--length])
                .topName(Arrays.stream(pkgNames).limit(length).collect(Collectors.joining(".")))
                .build();
    }

    /**
     * 获得 SpringBoot 启动类
     * @return  SpringBoot 启动类
     * @link {https://developer.aliyun.com/article/616541}
     */
    public static Class<?> getSpringBootApplicationClass() {
        try {
            Class<?> mainClass = null;
            Set<Class<?>> mainClassSet = ClassScanner.scanPackageByAnnotation("", SpringBootApplication.class);
            if (CollUtil.isEmpty(mainClassSet) || mainClassSet.size() > 1) {
                throw new RuntimeException("当前项目不是 Spring Boot 项目");
            }
            mainClass = mainClassSet.stream().findFirst().orElse(null);
            return mainClass;
        } catch (ArrayStoreException e) {
            e.printStackTrace();
            return null;
        }
    }

}
