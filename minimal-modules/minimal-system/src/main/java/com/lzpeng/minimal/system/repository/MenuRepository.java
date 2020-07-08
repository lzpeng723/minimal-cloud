package com.lzpeng.minimal.system.repository;

import com.lzpeng.minimal.common.jpa.repository.TreeRepository;
import com.lzpeng.minimal.system.domain.entity.Menu;
import com.lzpeng.minimal.system.domain.enums.MenuType;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.annotation.Generated;
import java.util.List;

/**
* 权限菜单 数据层
* @author: Lzpeng
*/
@Api(tags = "权限菜单 Entity")
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-25 2:02:06", comments = "权限菜单 数据层")
public interface MenuRepository extends TreeRepository<Menu> {

    /**
    * 更新权限菜单状态
    * @param id 权限菜单id
    * @param enabled 权限菜单状态
    * @return 更新成功的条数
    */
    @Override
    @Modifying
    @Query("UPDATE Menu t SET t.enabled = :enabled WHERE t.id = :id")
    int updateEnabled(@Param("id") String id, @Param("enabled") Boolean enabled);


    /**
     * 查找不是此类型且不是外链的菜单
     * @param menuType 菜单类型
     * @return 不是此类型且不是外链的菜单
     */
    List<Menu> findAllByTypeNotAndFrameIsFalse(MenuType menuType);


}
