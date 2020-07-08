package com.lzpeng.minimal.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.annotation.Generated;

import javax.transaction.Transactional;

/**
* 测试实体 业务层
* @author: JpaCodeGenerator
*/
@Slf4j
@Service
@Transactional(rollbackOn = Exception.class)
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-7-7 18:31:21", comments = "测试实体 业务层")
public class DemoEntityService extends AbstractDemoEntityService {

}
