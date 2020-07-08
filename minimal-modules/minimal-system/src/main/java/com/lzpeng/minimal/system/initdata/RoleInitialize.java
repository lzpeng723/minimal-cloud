package com.lzpeng.minimal.system.initdata;

import cn.hutool.core.io.IoUtil;
import com.lzpeng.minimal.common.core.response.QueryResult;
import com.lzpeng.minimal.system.domain.entity.Role;
import com.lzpeng.minimal.system.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * 初始化角色
 * @author: 李志鹏
 */
@Slf4j
@Component
@Order(Ordered.HIGHEST_PRECEDENCE + 2)
public class RoleInitialize implements ApplicationRunner {

    /**
     * 角色Service
     */
    @Autowired
    private RoleService roleService;

    /**
     * 角色初始化数据
     */
    private Resource roleData = new ClassPathResource("initdata/role.json");


    /**
     * 初始化角色
     * @param args 程序启动参数
     * @throws IOException 文件读取异常
     */
    @Override
    @Transactional(rollbackOn = Exception.class)
    public void run(ApplicationArguments args) throws IOException {
        QueryResult<Role> result = roleService.query(1, 1);
        if (result.isEmpty()) {
            roleService.importDataFromJson(IoUtil.read(roleData.getInputStream(), Charset.defaultCharset()));
            log.info("初始化角色信息成功");
            SysStatic.needInit = true;
        }
    }
}
