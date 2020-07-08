package com.lzpeng.minimal.common.swagger;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.lzpeng.minimal.common.core.domain.ProjectInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author: Lzpeng
 */
@Configuration
@EnableKnife4j
@EnableSwagger2
@ConditionalOnWebApplication
public class SwaggerAutoConfiguration {

    @Value("${spring.application.name:swagger}")
    private String name;

    public static ApiInfo apiInfo(String title, String description, String version) {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .version(version)
                .build();
    }

    @Bean
    public Docket swaggerApi() {
        ProjectInfo projectInfo = ProjectInfo.get();
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(name)
                .apiInfo(apiInfo(name + "API", name + "API", "1.0"))
                .select()
                .apis(RequestHandlerSelectors.basePackage(projectInfo.getBaseModulePackage()))
                .paths(PathSelectors.any())
                .build();
    }
}
