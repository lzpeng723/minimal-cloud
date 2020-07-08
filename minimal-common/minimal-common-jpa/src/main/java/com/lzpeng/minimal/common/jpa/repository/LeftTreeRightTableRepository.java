package com.lzpeng.minimal.common.jpa.repository;


import com.lzpeng.minimal.common.jpa.domain.entity.LeftTreeRightTableEntity;
import com.lzpeng.minimal.common.jpa.domain.entity.TreeEntity;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author: Lzpeng
 */
@NoRepositoryBean
public interface LeftTreeRightTableRepository<Tree extends TreeEntity<Tree>, Entity extends LeftTreeRightTableEntity<Tree>> extends BaseRepository<Entity> {
}
