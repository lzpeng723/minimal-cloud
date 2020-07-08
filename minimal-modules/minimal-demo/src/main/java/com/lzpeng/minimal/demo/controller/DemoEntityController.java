package com.lzpeng.minimal.demo.controller;


import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Generated;

/**
* 测试实体Controller
* @author: JpaCodeGenerator
*/
@Slf4j
@RestController
@RequestMapping("/demo/demoEntity")
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-7-7 18:31:21", comments = "测试实体控制层")
@Api(tags = "测试实体管理接口", value = "测试实体管理，提供测试实体的增、删、改、查等功能")
public class DemoEntityController extends AbstractDemoEntityController {

}