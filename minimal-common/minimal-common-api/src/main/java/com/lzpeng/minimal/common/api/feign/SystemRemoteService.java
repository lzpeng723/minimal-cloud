package com.lzpeng.minimal.common.api.feign;

import com.lzpeng.minimal.common.core.domain.dto.MenuDTO;
import com.lzpeng.minimal.common.api.domain.dto.UserInfo;
import com.lzpeng.minimal.common.core.constant.ServiceNameConstants;
import com.lzpeng.minimal.common.core.response.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 系统管理模块远程调用Service
 * @author : Lzpeng
 */
@FeignClient(contextId = "systemRemoteService", value = ServiceNameConstants.SYSTEM_SERVICE, fallbackFactory = SystemRemoteFallbackFactory.class)
public interface SystemRemoteService {

    /**
     * 获得当前登录用户
     * @return 当前登录用户
     */
    @GetMapping("/system/user/me")
    UserInfo getCurrentUser();

    /**
     * 保存请求日志
     * Feign 文件上传配置
     * @param file 文件
     * @return 请求日志
     * @link https://gitee.com/didispace/SpringCloud-Learning/blob/master/2-Dalston版教程示例/eureka-feign-upload-client/src/main/java/com/didispace/api/consumer/UploadService.java
     */
    @PostMapping(value = "/system/menu/import",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Result<List<MenuDTO>> importMenuData(@RequestPart("file") MultipartFile file);

}
