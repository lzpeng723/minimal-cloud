package com.lzpeng.minimal.system.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Generated;
import javax.transaction.Transactional;

/**
* 通知 业务层
* @author: Lzpeng
*/
@Slf4j
@Service
@Transactional(rollbackOn = Exception.class)
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-25 2:02:06", comments = "通知 业务层")
public class NoticeService extends AbstractNoticeService {

}
