package com.lzpeng.minimal.system.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.lzpeng.minimal.common.jpa.service.TreeService;
import com.lzpeng.minimal.system.domain.entity.Menu;
import com.lzpeng.minimal.system.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Generated;
import javax.transaction.Transactional;
import java.util.List;

/**
* 权限菜单 抽象业务层 提供基于注解的缓存配置
* @author: JpaCodeGenerator
*/
@Service
@Transactional(rollbackOn = Exception.class)
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-27 12:42:04", comments = "权限菜单 抽象业务层 提供基于注解的缓存配置")
public abstract class AbstractMenuService extends TreeService<Menu> {


    /**
    * 权限菜单实体类类全路径
    */
    protected static final String ENTITY_NAME = "com.lzpeng.minimal.system.domain.entity.Menu";

    /**
    * 权限菜单Repository
    */
    protected MenuRepository menuRepository;

    /**
    * IOC自动注入权限菜单Repository
    * @param menuRepository 权限菜单Repository
    */
    @Autowired
    public void setMenuRepository(MenuRepository menuRepository) {
        this.baseRepository = menuRepository;
        this.treeRepository = menuRepository;
        this.menuRepository = menuRepository;
    }


    /**
    * 保存权限菜单
    * @param menu 权限菜单数据
    * @return 保存之后的权限菜单
    */
    @Override
    @CachePut(value = ENTITY_NAME, key = "#result.id", unless = "#result == null")
    public Menu save(Menu menu) {
        return super.save(menu);
    }

    /**
    * 删除权限菜单
    * @param id 权限菜单id
    */
    @Override
    @CacheEvict(value = ENTITY_NAME, key = "#id")
    public void delete(String id) {
        super.delete(id);
    }

    /**
    * 根据 id 更新权限菜单
    * @param id id 权限菜单id
    * @param model 更新的权限菜单
    * @return 更新后的结果
    */
    @Override
    @CachePut(value = ENTITY_NAME, key = "#id", unless = "#result == null")
    public Menu update(String id, Menu model) {
        return super.update(id, model);
    }

    /**
    * 根据ID查询权限菜单
    * @param id 权限菜单id
    * @return 权限菜单
    */
    @Override
    @Cacheable(value = ENTITY_NAME, key = "#id", unless = "#result == null")
    public Menu findById(String id) {
        return super.findById(id);
    }

    /**
    * 从 json 读取实体列表
    * 必须重写此方法否则,TypeReference获取不到泛型参数
    * @param json json字符串
    * @return 实体列表
    * @throws JsonProcessingException json解析异常
    */
    @Override
    public List<Menu> readDataFromJson(String json) throws JsonProcessingException {
        List<Menu> list = objectMapper.readValue(json, new TypeReference<List<Menu>>() {
        });
        return list;
    }

}
