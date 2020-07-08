package com.lzpeng.minimal.generate.jpa;

import com.lzpeng.minimal.generate.core.AbstractCodeGenerator;
import com.lzpeng.minimal.generate.core.EntityParser;
import com.lzpeng.minimal.generate.core.GenConfig;
import lombok.SneakyThrows;

import java.io.IOException;

/**
 * JPA 代码生成器
 * @author : Lzpeng
 */
public class JpaCodeGenerator extends AbstractCodeGenerator {


    @Override
    protected Class<?>[] scanEntity(Class<?>... basePackageClasses) {
        return JpaEntityScanner.scan(basePackageClasses);
    }

    @Override
    protected EntityParser getEntityParser() {
        return JpaEntityParser::parser;
    }

    /**
     * 获取默认代码生成配置,
     * 抽象类尝试放到 target/generated-sources/java
     * 但是在执行 mvn clean 时会自动删除
     * 于是还放置 src/main/java
     * @return
     * @throws IOException
     */
    @Override
    @SneakyThrows
    protected GenConfig[] getDefaultGenConfigs() {
        return new GenConfig[]{
                getGenConfig("templates/AbstractDTO.java.ftl",
                        "src/main/java/${baseModulePackage?replace('.','/')}/domain/dto/Abstract${simpleClassName}DTO.java"),
                getGenConfig("templates/DTO.java.ftl",
                        "src/main/java/${baseModulePackage?replace('.','/')}/domain/dto/${simpleClassName}DTO.java", true),
                getGenConfig("templates/Mapper.java.ftl",
                        "src/main/java/${baseModulePackage?replace('.','/')}/domain/mapper/${simpleClassName}Mapper.java", true),
                getGenConfig("templates/Repository.java.ftl",
                        "src/main/java/${baseModulePackage?replace('.','/')}/repository/${simpleClassName}Repository.java"),
                getGenConfig("templates/RepositoryTest.java.ftl",
                        "src/test/java/${baseModulePackage?replace('.','/')}/repository/${simpleClassName}RepositoryTest.java"),
                getGenConfig("templates/AbstractService.java.ftl",
                        "src/main/java/${baseModulePackage?replace('.','/')}/service/Abstract${simpleClassName}Service.java", true),
                getGenConfig("templates/Service.java.ftl",
                        "src/main/java/${baseModulePackage?replace('.','/')}/service/${simpleClassName}Service.java"),
                getGenConfig("templates/ServiceTest.java.ftl",
                        "src/test/java/${baseModulePackage?replace('.','/')}/service/${simpleClassName}ServiceTest.java"),
                getGenConfig("templates/AbstractController.java.ftl",
                        "src/main/java/${baseModulePackage?replace('.','/')}/controller/Abstract${simpleClassName}Controller.java", true),
                getGenConfig("templates/Controller.java.ftl",
                        "src/main/java/${baseModulePackage?replace('.','/')}/controller/${simpleClassName}Controller.java"),
                getGenConfig("templates/ControllerTest.java.ftl",
                        "src/test/java/${baseModulePackage?replace('.','/')}/controller/${simpleClassName}ControllerTest.java"),
                getGenConfig("templates/index.vue.ftl",
                        "src/minimal/vue/src/views/${moduleName}/${simpleClassName?uncap_first}/index.vue"),
                getGenConfig("templates/dialog.vue.ftl",
                        "src/minimal/vue/src/views/${moduleName}/${simpleClassName?uncap_first}/components/${simpleClassName}Dialog.vue"),
                getGenConfig("templates/detail.vue.ftl",
                        "src/minimal/vue/src/views/${moduleName}/${simpleClassName?uncap_first}/${simpleClassName}Detail.vue"),
                getGenConfig("templates/api.js.ftl",
                        "src/minimal/vue/src/api/${moduleName}/${simpleClassName?uncap_first}.js")
        };
    }

}
