package com.lzpeng.minimal.common.api.feign;

import com.lzpeng.minimal.common.api.domain.dto.RequestLogDTO;
import com.lzpeng.minimal.common.api.domain.dto.UserInfo;
import com.lzpeng.minimal.common.core.response.Result;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 远程调用服务工具平台模块失败处理
 * @author : Lzpeng
 */
@Slf4j
@Component
public class ToolRemoteFallbackFactory implements FallbackFactory<ToolRemoteService> {
    @Override
    public ToolRemoteService create(Throwable cause) {
        return new ToolRemoteService() {
            @Override
            public Result<RequestLogDTO> saveRequestLog(RequestLogDTO requestLogDTO) {
                log.error("ToolRemoteService ERROR :", cause);
                // TODO 考虑发送消息到 MQ
                return null;
            }
        };
    }
}
