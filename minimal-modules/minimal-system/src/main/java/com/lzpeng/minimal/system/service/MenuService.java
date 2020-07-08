package com.lzpeng.minimal.system.service;

import cn.hutool.core.bean.BeanUtil;
import com.lzpeng.minimal.common.jpa.util.TreeEntityUtil;
import com.lzpeng.minimal.system.domain.entity.Menu;
import com.lzpeng.minimal.system.domain.entity.MenuMeta;
import com.lzpeng.minimal.system.domain.entity.User;
import com.lzpeng.minimal.system.domain.enums.MenuType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Generated;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
* 权限菜单 业务层
* @author: Lzpeng
*/
@Slf4j
@Service
@Transactional(rollbackOn = Exception.class)
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-25 2:02:06", comments = "权限菜单 业务层")
public class MenuService extends AbstractMenuService {

    @Autowired
    private UserService userService;

    /**
     * 得到用户路由菜单
     * @return
     */
    public List<Menu> getRouters() {
        User userDetails = userService.getCurrentUser();
        if (userDetails instanceof User) {
            User user = (User) userDetails;
            List<Menu> menus = user.getRoles().stream()
                    .flatMap(role -> role.getMenus().stream())
                    .distinct()
                    // 去掉功能类权限菜单
                    .filter(menu -> !menu.getType().equals(MenuType.FUNCTION))
                    .peek(menu -> {
                        MenuMeta meta = new MenuMeta();
                        // 拷贝元数据信息
                        BeanUtil.copyProperties(menu, meta);
                        // 设置元数据信息
                        menu.setMeta(meta);
                    })
                    .collect(Collectors.toList());
            return TreeEntityUtil.treeData(menus);
        }
        return Arrays.asList();
    }

    /**
     * 获得所有路由菜单
     * 不是功能(按钮)且不是外链的菜单
     * @return
     */
    public List<Menu> getAllRouters() {
        List<Menu> menus = menuRepository.findAllByTypeNotAndFrameIsFalse(MenuType.FUNCTION);
        return TreeEntityUtil.treeData(menus);
    }
}
