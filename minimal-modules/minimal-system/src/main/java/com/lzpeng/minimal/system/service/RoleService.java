package com.lzpeng.minimal.system.service;

import com.lzpeng.minimal.common.core.response.QueryResult;
import com.lzpeng.minimal.common.jpa.domain.entity.BaseEntity;
import com.lzpeng.minimal.common.jpa.util.TreeEntityUtil;
import com.lzpeng.minimal.system.domain.entity.Menu;
import com.lzpeng.minimal.system.domain.entity.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Generated;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
* 角色 业务层
* @author: Lzpeng
*/
@Slf4j
@Service
@Transactional(rollbackOn = Exception.class)
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-25 2:02:06", comments = "角色 业务层")
public class RoleService extends AbstractRoleService {

    /**
     * 菜单Service
     */
    @Autowired
    private MenuService menuService;

    /**
     * 保存前操作
     * @param role 即将保存的角色
     * @return 是否还需要保存
     */
    @Override
    protected boolean beforeSave(Role role) {
        Collection<Menu> menus = role.getMenus();
        menus = TreeEntityUtil.flatData(menus);
        role.setMenus(menus);
        return true;
    }

    /**
     * 分配权限
     * @param id 角色id
     * @param permissions 权限id数组
     * @return 分配完权限的角色
     */
    public Role setPermissions(String id, String[] permissions) {
        Role role = findById(id);
        List<Menu> menus = menuService.findAllById(Arrays.asList(permissions));
        role.setMenus(menus);
        role = save(role);
        return role;
    }

    /**
     * 根据查询条件和分页条件查询角色
     * @param page 页码
     * @param size 每页行数
     * @param model JPA Example 查询条件
     * @return 符合条件的角色列表
     */
    @Override
    public QueryResult<Role> query(int page, int size, Role model) {
        QueryResult<Role> result = super.query(page, size, model);
        for (Role role : result.getList()) {
            Collection<Menu> menus = role.getMenus();
            menus = TreeEntityUtil.flatData(menus);
            role.setMenus(menus);
        }
        return result;
    }

    /**
     * 得到角色未拥有的权限列表
     * @param roleId 角色id
     * @return 未拥有的权限
     */
    public List<Menu> noPermissions(String roleId) {
        Role role = findById(roleId);
        if (role.getMenus().isEmpty()) {
            return menuService.findAll();
        }
        List<String> menuIds = role.getMenus().stream().map(BaseEntity::getId).distinct().collect(Collectors.toList());
        List<Menu> menus = menuService.findAllByIdNotIn(menuIds);
        menus = TreeEntityUtil.flatData(menus);
        return menus;
    }
}
