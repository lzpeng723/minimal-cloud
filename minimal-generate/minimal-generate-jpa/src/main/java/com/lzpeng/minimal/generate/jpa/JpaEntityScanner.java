package com.lzpeng.minimal.generate.jpa;

import cn.hutool.core.lang.ClassScanner;
import com.lzpeng.minimal.common.jpa.domain.entity.BaseEntity;
import org.springframework.core.io.support.ResourcePatternUtils;

import javax.persistence.Entity;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Jpa 实体类扫描器
 *
 * @author : Lzpeng
 */
public class JpaEntityScanner {

    /**
     * 扫描 Jpa 实体类
     * @param basePackageClasses 根包中的类
     * @return Jpa 实体类列表
     * @see ResourcePatternUtils#getResourcePatternResolver(org.springframework.core.io.ResourceLoader)
     */
    public static Class[] scan(Class<?>... basePackageClasses) {
        Set<String> scanPackages = getScanPackages(basePackageClasses);
        Set<Class<?>> result = new HashSet<>();
        for (String scanPackage : scanPackages) {
            Set<Class<?>> classes = ClassScanner.scanPackage(scanPackage, clazz ->
                    BaseEntity.class.isAssignableFrom(clazz)
                            && !BaseEntity.class.equals(clazz)
                            && clazz.isAnnotationPresent(Entity.class));
            result.addAll(classes);
        }
        return result.toArray(new Class[0]);
    }

    /**
     * 排重、检测package父子关系，避免多次扫描
     *
     * @param basePackageClasses
     * @return 返回检查后有效的路径集合
     */
    private static Set<String> getScanPackages(Class<?>... basePackageClasses) {
        Set<String> result = new HashSet<>();
        String[] scanPackages = Stream.of(basePackageClasses)
                .map(Class::getPackage)
                .map(Package::getName)
                .sorted()
                .toArray(String[]::new);
        String prePackage = null;
        for (int i = 0; i < scanPackages.length; i++) {
            String scanPackage = scanPackages[i];
            if (prePackage != null && scanPackage.startsWith(prePackage)) {
                continue;
            } else {
                result.add(scanPackage);
                prePackage = scanPackage;
            }
        }
        return result;
    }
}
