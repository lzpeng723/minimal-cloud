package com.lzpeng.minimal.common.jpa.service;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.TypeUtil;
import com.lzpeng.minimal.common.core.response.QueryResult;
import com.lzpeng.minimal.common.jpa.domain.entity.LeftTreeRightTableEntity;
import com.lzpeng.minimal.common.jpa.domain.entity.TreeEntity;
import com.lzpeng.minimal.common.jpa.repository.LeftTreeRightTableRepository;
import lombok.SneakyThrows;

import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.util.List;

/**
 * 左树右表Service
 * @author: Lzpeng
 */
@Transactional(rollbackOn = Exception.class)
public class LeftTreeRightTableService<Tree extends TreeEntity<Tree>, Entity extends LeftTreeRightTableEntity<Tree>> extends BaseService<Entity> {


    /**
     * 左树 Service
     */
    protected TreeService<Tree> treeService;

    /**
     * 左树右表 Repository
     */
    protected LeftTreeRightTableRepository<Tree, Entity> leftTreeRightTableRepository;

    /**
     * 保存实体
     * @param entity 要保存的实体
     * @return 保存成功的实体
     */
    @Override
    public Entity save(Entity entity) {
        if (entity.getTreeId() != null) {
            entity.setTree(treeService.findById(entity.getTreeId()));
        }
        return super.save(entity);
    }

    /**
     * 获得左树数据
     * @return 左树数据
     */
    public List<Tree> leftTreeData(){
        return treeService.treeData();
    }

    /**
     * 根据查询条件和分页条件查询实体
     * @param page 页码
     * @param size 每页行数
     * @param model JPA Example 查询条件
     * @return 符合条件的实体列表
     */
    @Override
    @SneakyThrows
    public QueryResult<Entity> query(int page, int size, Entity model) {
        if (model != null && StrUtil.isNotEmpty(model.getTreeId())){
            Tree tree = getLeftTreeClass().getDeclaredConstructor().newInstance();
            tree.setId(model.getTreeId());
            model.setTree(tree);
        }
        return super.query(page, size, model);
    }


    /**
     * 得到左树实体类型
     * @return 左树实体类型
     */
    protected Class<Tree> getLeftTreeClass(){
        Type type = TypeUtil.getTypeArgument(getClass());
        if (type != null && type instanceof Class) {
            return (Class<Tree>) type;
        }
        return null;
    }

    /**
     * 得到右表实体类型
     * @return 右表实体类型
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
