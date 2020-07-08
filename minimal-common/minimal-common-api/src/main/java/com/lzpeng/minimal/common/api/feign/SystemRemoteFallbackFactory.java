package com.lzpeng.minimal.common.api.feign;

import com.lzpeng.minimal.common.api.domain.dto.UserInfo;
import com.lzpeng.minimal.common.core.domain.dto.MenuDTO;
import com.lzpeng.minimal.common.core.response.Result;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 远程调用系统管理模块失败处理
 * @author : Lzpeng
 */
@Slf4j
@Component
public class SystemRemoteFallbackFactory implements FallbackFactory<SystemRemoteService> {
    @Override
    public SystemRemoteService create(Throwable cause) {
        return new SystemRemoteService() {
            @Override
            public UserInfo getCurrentUser() {
                log.error("SystemRemoteService ERROR :", cause);
                return null;
            }

            @Override
            public Result<List<MenuDTO>> importMenuData(MultipartFile file) {
                log.error("SystemRemoteService ERROR :", cause);
                return null;
            }
        };
    }
}
