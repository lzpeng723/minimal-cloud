package com.lzpeng.minimal.common.core.controller;

import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Lzpeng
 */
public class BaseController {
    /**
     * HTTP请求
     */
    protected HttpServletRequest request;

    /**
     * HTTP响应
     */
    protected HttpServletResponse response;

    /**
     * HTTP Session
     */
    protected HttpSession session;

    /**
     * 每次请求前设置 HTTP 请求响应和 Session
     * @param request HTTP 请求
     * @param response HTTP 响应
     */
    @ModelAttribute
    public void setRequestAndResponse(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.session = request.getSession();
    }
}
