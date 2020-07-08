package com.lzpeng.minimal.common.core.config.feign;

import feign.Logger;
import feign.form.spring.SpringFormEncoder;
import org.springframework.context.annotation.Bean;
import feign.codec.Encoder;

/**
 * feign的配置类
 * 这个类别加@Configuration注解了，否则必须挪到@ComponentScan能扫描的包以外
 * @author Lzpeng
 */
public class FeignFullLogConfiguration {
    /**
     * 打印全部Feign日志
     * @return 打印全部Feign日志
     */
    @Bean
    public Logger.Level level(){
        // 让feign打印所有请求的细节
        return Logger.Level.FULL;
    }

    /**
     * Feign 文件上传配置
     * @return 文件上传配置
     * @link https://gitee.com/didispace/SpringCloud-Learning/blob/master/2-Dalston版教程示例/eureka-feign-upload-client/src/main/java/com/didispace/api/consumer/UploadService.java
     */
    @Bean
    public Encoder feignFormEncoder() {
        return new SpringFormEncoder();
    }
}
