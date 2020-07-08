package com.lzpeng.minimal.system.initdata;

import com.lzpeng.minimal.system.domain.entity.*;
import com.lzpeng.minimal.system.service.MenuService;
import com.lzpeng.minimal.system.service.RoleService;
import com.lzpeng.minimal.system.service.UserService;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

/**
 * 初始化系统管理模块
 *
 * @author: 李志鹏
 */
@Slf4j
@Component
@Order(Ordered.HIGHEST_PRECEDENCE + 3)
public class SysInitialize implements ApplicationRunner {

    /**
     * 用户Service
     */
    @Autowired
    private UserService userService;

    /**
     * 菜单Service
     */
    @Autowired
    private MenuService menuService;

    /**
     * 角色Service
     */
    @Autowired
    private RoleService roleService;

    /**
     * Query DSL 通用查询器
     */
    @Autowired
    private JPAQueryFactory jpaQueryFactory;


    /**
     * 初始化为用户分配角色,角色分配菜单
     *
     * @param args 程序启动参数
     */
    @Override
    @Transactional(rollbackOn = Exception.class)
    public void run(ApplicationArguments args) {
        if (SysStatic.needInit) {
            SysStatic.needInit = false;
            User administratorUser = userService.findByUsername("administrator");
            User userUser = userService.findByUsername("user");
            Role adminRole = jpaQueryFactory.selectFrom(QRole.role).where(QRole.role.number.eq("ADMIN")).fetchOne();
            Role userRole = jpaQueryFactory.selectFrom(QRole.role).where(QRole.role.number.eq("USER")).fetchOne();
            assert adminRole != null;
            userService.setRoles(administratorUser.getId(), new String[]{adminRole.getId()});
            assert userRole != null;
            userService.setRoles(userUser.getId(), new String[]{userRole.getId()});
            log.info("初始化用户角色关联信息成功");
            List<Menu> adminMenus = menuService.findAll();
            adminRole.setMenus(adminMenus);
            roleService.save(adminRole);
            List<Menu> userMenus = jpaQueryFactory.selectFrom(QMenu.menu).where(QMenu.menu.number.endsWith("query").or(QMenu.menu.number.endsWith("export"))).fetch();
            roleService.setPermissions(userRole.getId(), userMenus.stream().map(Menu::getId).toArray(String[]::new));
            log.info("初始化角色菜单关联信息成功");
        }
    }
}
