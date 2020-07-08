package com.lzpeng.minimal.common.jpa.controller;

import cn.hutool.core.util.TypeUtil;
import com.lzpeng.minimal.common.core.response.Result;
import com.lzpeng.minimal.common.core.response.ResultUtil;
import com.lzpeng.minimal.common.jpa.domain.entity.LeftTreeRightTableEntity;
import com.lzpeng.minimal.common.jpa.domain.entity.TreeEntity;
import com.lzpeng.minimal.common.jpa.service.LeftTreeRightTableService;

import java.lang.reflect.Type;
import java.util.List;

/**
 * 左树右表Controller
 * @author: Lzpeng
 */
public class LeftTreeRightTableController<Tree extends TreeEntity<Tree>, Entity extends LeftTreeRightTableEntity<Tree>> extends BaseController<Entity> {

    /**
     * 泛型注入
     */
    protected LeftTreeRightTableService<Tree, Entity> leftTreeRightTableService;

    /**
     * 获得左树数据
     * @return 左树数据
     */
    public Result<List<Tree>> leftTreeData(){
        List<Tree> leftTreeData = leftTreeRightTableService.leftTreeData();
        return ResultUtil.success(leftTreeData);
    }

    /**
     * 得到左树类型
     * @return 左树类型
     */
    protected Class<Tree> getLeftTreeClass(){
        Type type = TypeUtil.getTypeArgument(getClass());
        if (type != null && type instanceof Class) {
            return (Class<Tree>) type;
        }
        return null;
    }

    /**
     * 得到右表类型
     * @return 右表类型
     */
    protected Class<Entity> getRightTableClass(){
        Type type = TypeUtil.getTypeArgument(getClass(), 1);
        if (type != null && type instanceof Class) {
            return (Class<Entity>) type;
        }
        return null;
    }

    @Override
    protected Class<Entity> getEntityClass() {
        return this.getRightTableClass();
    }
}
