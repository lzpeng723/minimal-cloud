package com.lzpeng.minimal.common.core.config.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * Feign 传递请求头参数
 * @author: Lzpeng
 */
@SuppressWarnings("unused")
public class FeignRelayHeaderInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
        // 获取 Request
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes attributes = (ServletRequestAttributes) requestAttributes;
        assert attributes != null;
        HttpServletRequest httpServletRequest = attributes.getRequest();
        // 传递请求头参数, Authorization: Token
        Enumeration<String> headerNames = httpServletRequest.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            template.header(headerName, httpServletRequest.getHeader(headerName));
        }
    }
}
