package com.lzpeng.minimal.system.controller;


import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Generated;

/**
* 部门Controller
* @author: JpaCodeGenerator
*/
@Slf4j
@RestController
@RequestMapping("/system/department")
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-26 14:04:34", comments = "部门 控制层")
@Api(tags = "部门管理接口", value = "部门管理，提供部门的增、删、改、查")
public class DepartmentController extends AbstractDepartmentController {


}