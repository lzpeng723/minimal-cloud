package com.lzpeng.minimal.samplejpa.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.annotation.Generated;

import javax.transaction.Transactional;

/**
* 示例实体 业务层
* @author: JpaCodeGenerator
*/
@Slf4j
@Service
@Transactional(rollbackOn = Exception.class)
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-28 20:50:57", comments = "示例实体 业务层")
public class SampleEntityService extends AbstractSampleEntityService {

}
