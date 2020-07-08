package com.lzpeng.minimal.common.jpa.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lzpeng.minimal.common.core.response.QueryResult;
import com.lzpeng.minimal.common.jpa.domain.entity.TreeEntity;
import com.lzpeng.minimal.common.jpa.repository.TreeRepository;
import com.lzpeng.minimal.common.jpa.util.TreeEntityUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 树形结构Service
 * @author: Lzpeng
 */
public class TreeService<Entity extends TreeEntity<Entity>> extends BaseService<Entity> {


    @Autowired
    protected ObjectMapper objectMapper;

    /**
     * 泛型注入
     */
    protected TreeRepository<Entity> treeRepository;

    /**
     * 保存 遍历子节点 保存所有
     * 如果有父节点 将此对象加入父节点的孩子节点，并保存父节点
     * @param entity 要保存的实体
     * @return 保存后的结果
     */
    @Override
    public Entity save(Entity entity) {
        // 如果传了父节点id，则从数据库查询节点，级联保存
        if (entity.getParentId() != null) {
            Entity parent = findById(entity.getParentId());
            entity.setParent(parent);
        }
        // 队列，先进先出保存子节点
        Collection<Entity> entities = new HashSet<>();
        Queue<Entity> queue = new ConcurrentLinkedQueue<>();
        // 入队
        queue.offer(entity);
        while (!queue.isEmpty()) {
            // 出队
            Entity parent = queue.remove();
            // 给 每个 子节点 设置 parent
            for (Entity child : parent.getChildren()) {
                child.setParent(parent);
                // 入队
                queue.offer(child);
            }
            parent.getChildren().clear();
            entities.add(parent);
        }
        // 不能调 super.saveAll 会无限递归
        if (beforeSaveAll(entities)) {
            List<Entity> result = treeRepository.saveAll(entities);
            return result.get(0);
        }
        return null;
    }


    /**
     * 根据查询条件查询实体
     * @param model 模糊查询条件
     * @return 符合条件的实体列表
     */
    @Override
    public List<Entity> findAll(Entity model) {
        List<Entity> entities = super.findAll(model);
        // 将其父节点以及祖先节点加入返回结果中
        return TreeEntityUtil.flatData(entities);
    }


    /**
     * 根据查询条件和分页条件查询实体
     * @param page 页码
     * @param size 每页行数
     * @param model JPA Example 查询条件
     * @return 符合条件的实体列表
     */
    @Override
    public QueryResult<Entity> query(int page, int size, Entity model) {
        QueryResult<Entity> query = super.query(page, size, model);
        List<Entity> entities = query.getList();
        List<Entity> result = TreeEntityUtil.flatData(entities);
        return new QueryResult<>(result, query.getTotal(), query.getPage(), query.getTotalPage());
    }

    /**
     * 根据查询条件查询树形结构实体
     * @param model 查询条件
     * @return 符合条件的实体
     */
    public List<Entity> treeData(Entity model) {
        if (model == null) {
            return treeData();
        }
        List<Entity> entities = super.findAll(model);
        return TreeEntityUtil.treeData(entities);
    }

    /**
     * 查询所有树形结构实体
     * @return 返回树形结构的实体
     */
    public List<Entity> treeData() {
        List<Entity> entities = treeRepository.findByParentNullOrderByOrderNum();
        // 排序 设置父id
        TreeEntityUtil.sortTreeData(entities);
        // 查询后操作
        // afterFindAll(entities);
        return entities;
    }




}
