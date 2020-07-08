package com.lzpeng.minimal.samplejpa.controller;


import com.lzpeng.minimal.common.api.feign.SystemRemoteService;
import com.lzpeng.minimal.common.api.domain.dto.UserInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Generated;

/**
* 示例实体Controller
* @author: JpaCodeGenerator
*/
@Slf4j
@RestController
@RequestMapping("/samplejpa/sampleEntity")
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-28 20:50:57", comments = "示例实体控制层")
@Api(tags = "示例实体管理接口", value = "示例实体管理，提供示例实体的增、删、改、查等功能")
public class SampleEntityController extends AbstractSampleEntityController {

    @Lazy
    @Autowired
    private SystemRemoteService systemRemoteService;

    @GetMapping("/me")
    @ApiOperation("获取当前用户信息")
    public UserInfo currentUserInfo(){
        return systemRemoteService.getCurrentUser();
    }

}