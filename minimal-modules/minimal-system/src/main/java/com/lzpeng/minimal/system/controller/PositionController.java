package com.lzpeng.minimal.system.controller;


import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Generated;

/**
* 岗位Controller
* @author: JpaCodeGenerator
*/
@Slf4j
@RestController
@RequestMapping("/system/position")
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-26 14:04:34", comments = "岗位 控制层")
@Api(tags = "岗位管理接口", value = "岗位管理，提供岗位的增、删、改、查")
public class PositionController extends AbstractPositionController {


}