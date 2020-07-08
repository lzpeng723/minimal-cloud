package com.lzpeng.minimal.common.jpa.controller;

import com.lzpeng.minimal.common.core.response.Result;
import com.lzpeng.minimal.common.core.response.ResultUtil;
import com.lzpeng.minimal.common.jpa.domain.entity.TreeEntity;
import com.lzpeng.minimal.common.jpa.service.TreeService;

import java.util.List;

/**
 * 树表Controller
 * @author: Lzpeng
 */
public class TreeController<Entity extends TreeEntity<Entity>> extends BaseController<Entity> {

    /**
     * 泛型注入
     */
    protected TreeService<Entity> treeService;

    /**
     * 查询所有树形结构实体
     * @return 返回树形结构的实体
     */
    public Result<List<Entity>> treeData(){
        List<Entity> entities = treeService.treeData();
        return ResultUtil.success(entities);
    }

    /**
     * 根据查询条件查询树形结构实体
     * @param model 查询条件
     * @return 符合条件的实体
     */
    public Result<List<Entity>> treeData(Entity model) {
        List<Entity> entities = treeService.treeData(model);
        return ResultUtil.success(entities);
    }


}
