package com.lzpeng.minimal.tool.controller;

import com.lzpeng.minimal.common.api.feign.SystemRemoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Lzpeng
 */
@Slf4j
@RestController
@RequestMapping("/tool/test")
public class TestController {


    @Lazy
    @Autowired
    private SystemRemoteService systemRemoteService;

    @GetMapping("/me")
    public Object me(){
        return systemRemoteService.getCurrentUser();
    }

}
