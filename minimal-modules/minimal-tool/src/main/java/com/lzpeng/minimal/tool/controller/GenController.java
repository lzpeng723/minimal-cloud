package com.lzpeng.minimal.tool.controller;


import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Generated;

/**
* 代码生成模板Controller
* @author: JpaCodeGenerator
*/
@Slf4j
@RestController
@RequestMapping("/tool/gen")
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-27 23:21:56", comments = "代码生成模板控制层")
@Api(tags = "代码生成模板管理接口", value = "代码生成模板管理，提供代码生成模板的增、删、改、查等功能")
public class GenController extends AbstractGenController {

}