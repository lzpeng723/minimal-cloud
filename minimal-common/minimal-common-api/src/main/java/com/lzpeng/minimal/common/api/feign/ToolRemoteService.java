package com.lzpeng.minimal.common.api.feign;

import com.lzpeng.minimal.common.api.domain.dto.RequestLogDTO;
import com.lzpeng.minimal.common.api.domain.dto.UserInfo;
import com.lzpeng.minimal.common.core.constant.ServiceNameConstants;
import com.lzpeng.minimal.common.core.response.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 服务工具平台模块远程调用Service
 * @author : Lzpeng
 */
@FeignClient(contextId = "toolRemoteService", value = ServiceNameConstants.TOOL_SERVICE, fallbackFactory = ToolRemoteFallbackFactory.class)
public interface ToolRemoteService {

    /**
     * 保存请求日志
     * @param requestLogDTO 请求日志
     * @return 请求日志
     */
    @PostMapping("/tool/requestLog")
    Result<RequestLogDTO> saveRequestLog(@RequestBody RequestLogDTO requestLogDTO);

}
