package com.lzpeng.minimal.system.controller;


import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Generated;

/**
* 通知Controller
* @author: JpaCodeGenerator
*/
@Slf4j
@RestController
@RequestMapping("/system/notice")
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-26 14:04:34", comments = "通知 控制层")
@Api(tags = "通知管理接口", value = "通知管理，提供通知的增、删、改、查")
public class NoticeController extends AbstractNoticeController {


}