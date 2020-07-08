package com.lzpeng.minimal.common.jpa.repository;

import com.lzpeng.minimal.common.jpa.domain.entity.TreeEntity;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

/**
 * @author: Lzpeng
 */
@NoRepositoryBean
public interface TreeRepository<T extends TreeEntity<T>> extends BaseRepository<T> {

    /**
     * 返回树形结构
     * @return 以树状结构展示数据
     */
    List<T> findByParentNullOrderByOrderNum();
}
