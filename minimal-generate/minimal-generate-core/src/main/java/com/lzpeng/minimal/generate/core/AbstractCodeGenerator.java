package com.lzpeng.minimal.generate.core;

import cn.hutool.core.io.IoUtil;
import cn.hutool.extra.template.Template;
import cn.hutool.extra.template.TemplateEngine;
import cn.hutool.extra.template.TemplateUtil;
import com.lzpeng.minimal.common.core.domain.ProjectInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

/**
 * 抽象代码生成器
 *
 * @author : Lzpeng
 */
@Slf4j
public abstract class AbstractCodeGenerator {

    /**
     * 模板引擎
     */
    private static final TemplateEngine STRING_ENGINE = TemplateUtil.createEngine();

    /**
     * 扫描实体类列表
     * The package of each class specified will be scanned.
     *
     * @param basePackageClasses 扫描这些类所在包下的实体类
     * @return 实体类列表
     */
    protected abstract Class<?>[] scanEntity(Class<?>... basePackageClasses);

    /**
     * 获得 实体解析器
     *
     * @return 实体解析器
     */
    protected abstract EntityParser getEntityParser();

    /**
     * 生成代码文件到指定文件夹
     *
     * @param clazz      实体类
     * @param dir        目标文件夹
     * @param genConfigs 代码生成配置
     */
    public void generateCode(Class<?> clazz, String dir, GenConfig... genConfigs) {
        EntityParser entityParser = getEntityParser();
        Map<String, Object> model = entityParser.parser(clazz);
        for (GenConfig genConfig : genConfigs) {
            String path = STRING_ENGINE.getTemplate(genConfig.getPath()).render(model);
            Boolean override = genConfig.getOverride() != null ? genConfig.getOverride() : Boolean.FALSE;
            Path file = Paths.get(dir, path);
            if (Files.exists(file) && !override) {
                // 当文件存在且不覆盖生成时
                continue;
            }
            try {
                Files.createDirectories(file.getParent());
                Writer out = Files.newBufferedWriter(file);
                Template template = STRING_ENGINE.getTemplate(genConfig.getTemplate());
                template.render(model, out);
                out.flush();
                out.close();
                log.info("已生成 {}", path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 生成代码文件到用户目录
     *
     * @param clazz      实体类
     * @param genConfigs 代码生成配置
     */
    public void generateCode(Class<?> clazz, GenConfig... genConfigs) {
        generateCode(clazz, System.getProperty("user.dir"), genConfigs);
    }

    /**
     * 生成所有代码文件到用户目录
     *
     * @param path 文件生成目录
     * @param basePackageClass 扫描此类所在包下的所有实体类
     * @param genConfigs       代码生成配置
     */
    public void generateAllCode(String path, Class<?> basePackageClass, GenConfig... genConfigs) {
        if (genConfigs == null || genConfigs.length == 0) {
            genConfigs = getDefaultGenConfigs();
        }
        Class<?>[] entities = scanEntity(basePackageClass);
        for (Class<?> entity : entities) {
            generateCode(entity, path, genConfigs);
        }
    }


    /**
     * 生成所有代码文件到用户目录
     *
     * @param basePackageClass 扫描此类所在包下的所有实体类
     * @param genConfigs       代码生成配置
     */
    public void generateAllCode(Class<?> basePackageClass, GenConfig... genConfigs) {
        generateAllCode(System.getProperty("user.dir"), basePackageClass, genConfigs);
    }

    /**
     * 生成所有代码文件到用户目录
     *
     * @param genConfigs 代码生成配置
     */
    public void generateAllCode(GenConfig... genConfigs) {
        generateAllCode(ProjectInfo.getSpringBootApplicationClass(), genConfigs);
    }

    /**
     * 生成所有代码文件到用户目录
     *
     * @throws IOException 文件读取异常
     */
    public void generateAllCode() {
        generateAllCode(getDefaultGenConfigs());
    }

    /**
     * 获得默认代码生成配置
     *
     * @return 默认代码生成配置
     * @throws IOException 文件读取异常
     */
    protected abstract GenConfig[] getDefaultGenConfigs();


    /**
     * 获得一个代码生成配置,默认不覆盖生成
     *
     * @param templateFilePath 模板文件路径
     * @param genFilePath      生成文件路径
     * @return 一个代码生成配置
     * @throws IOException 文件读取异常
     */
    protected GenConfig getGenConfig(String templateFilePath, String genFilePath) throws IOException {
        return getGenConfig(templateFilePath, genFilePath, false);
    }
    /**
     * 获得一个代码生成配置
     *
     * @param templateFilePath 模板文件路径
     * @param genFilePath      生成文件路径
     * @param override         是否覆盖生成文件
     * @return 一个代码生成配置
     * @throws IOException 文件读取异常
     */
    protected GenConfig getGenConfig(String templateFilePath, String genFilePath, boolean override) throws IOException {
        ClassPathResource repository = new ClassPathResource(templateFilePath);
        String template = IoUtil.read(repository.getInputStream(), Charset.defaultCharset());
        return GenConfig.builder()
                .template(template)
                .path(genFilePath)
                .override(override)
                .build();
    }

}
