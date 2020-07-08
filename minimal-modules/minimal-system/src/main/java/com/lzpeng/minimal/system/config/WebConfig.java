package com.lzpeng.minimal.system.config;

import com.lzpeng.minimal.common.core.converter.IntegerToEnumConverterFactory;
import com.lzpeng.minimal.common.core.converter.StringToIntEnumConverterFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * 过滤器，拦截器配置
 * @author 李志鹏
 *
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Autowired
	private RequestLogInterceptor requestLogInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	    // 拦截器注册器
		registry.addInterceptor(requestLogInterceptor)
				.excludePathPatterns("/**/webjars/**")
				.excludePathPatterns("/static/**")
				.excludePathPatterns("/swagger-resources/**")
				.excludePathPatterns("/error/**")
				.addPathPatterns("/**");
	}


	/**
	 * 枚举类的转换器工厂 addConverterFactory
	 */
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverterFactory(new IntegerToEnumConverterFactory());
		registry.addConverterFactory(new StringToIntEnumConverterFactory());
	}

}
