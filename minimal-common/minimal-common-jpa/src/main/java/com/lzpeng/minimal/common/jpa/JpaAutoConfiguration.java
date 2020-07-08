package com.lzpeng.minimal.common.jpa;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;

import javax.persistence.EntityManager;
import java.util.Optional;

/**
 * @author: Lzpeng
 */
@EnableJpaAuditing
@ComponentScan(basePackageClasses = JpaAutoConfiguration.class)
public final class JpaAutoConfiguration {

    /**
     * 获得实体默认创建者更新者
     * @see org.springframework.data.jpa.repository.config.EnableJpaAuditing
     * @see org.springframework.data.jpa.domain.support.AuditingEntityListener
     * @return 实体默认创建者更新者
     */
    @Bean
    @ConditionalOnMissingBean
    public AuditorAware<String> auditorAware(){
        return () -> Optional.of("默认创建者");
    }

    /**
     * QueryDsl 复杂查询使用
     * @param entityManager hibernate 实体管理器
     * @return QueryDsl查询器
     */
    @Bean
    @ConditionalOnMissingBean
    public JPAQueryFactory jpaQueryFactory(EntityManager entityManager) {
        return new JPAQueryFactory(entityManager);
    }

    /**
     * SpringBoot jpa 使用懒加载时，报异常：session失效
     * 要使用懒加载特性必须配置此 Bean
     * spring.jpa.open-in-view: true
     * @see javax.transaction.Transactional
     * @see org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter
     * @see org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration.JpaWebConfiguration
     */
    @Bean
    @ConditionalOnMissingBean
    public OpenEntityManagerInViewFilter openEntityManagerInViewFilter() {
        return new OpenEntityManagerInViewFilter();
    }


    /**
     * Hibernate5Module.Feature.FORCE_LAZY_LOADING 加载所有管理实体
     * 序列化使用转换器
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        ObjectMapper mapper = converter.getObjectMapper();
        Hibernate5Module hibernate5Module = new Hibernate5Module();
        // 禁用 {@link javax.persistence.Transient} 检验,使其仍可被序列化到前台
        hibernate5Module.disable(Hibernate5Module.Feature.USE_TRANSIENT_ANNOTATION);
        hibernate5Module.enable(Hibernate5Module.Feature.REQUIRE_EXPLICIT_LAZY_LOADING_MARKER);
        // Spring Boot JPA Entity Jackson序列化触发懒加载的解决方案 https://www.cnblogs.com/ymstars/p/10473425.html
        mapper.registerModule(hibernate5Module);
        // 忽略空属性
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        // https://blog.csdn.net/J080624/article/details/82529082
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        return converter;
    }
}
