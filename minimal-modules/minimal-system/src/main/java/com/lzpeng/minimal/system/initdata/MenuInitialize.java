package com.lzpeng.minimal.system.initdata;

import cn.hutool.core.io.IoUtil;
import com.lzpeng.minimal.common.core.response.QueryResult;
import com.lzpeng.minimal.system.domain.entity.Menu;
import com.lzpeng.minimal.system.service.MenuService;
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
 * 初始化菜单
 * @author: 李志鹏
 */
@Slf4j
@Component
@Order(Ordered.HIGHEST_PRECEDENCE + 2)
public class MenuInitialize implements ApplicationRunner {

    /**
     * 菜单Service
     */
    @Autowired
    private MenuService menuService;

    /**
     * 菜单初始化数据
     */
    private Resource menuData = new ClassPathResource("initdata/menu.json");

    /**
     * 初始化菜单
     * @param args 程序启动参数
     * @throws IOException 文件读取异常
     */
    @Override
    @Transactional(rollbackOn = Exception.class)
    public void run(ApplicationArguments args) throws IOException {
        QueryResult<Menu> result = menuService.query(1, 1);
        if (result.isEmpty()) {
            menuService.importDataFromJson(IoUtil.read(menuData.getInputStream(), Charset.defaultCharset()));
            log.info("初始化菜单信息成功");
            SysStatic.needInit = true;
        }
    }
}
