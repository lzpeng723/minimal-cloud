package com.lzpeng.minimal.common.jpa.support;

import cn.hutool.core.lang.Snowflake;
import com.lzpeng.minimal.common.core.domain.ProjectInfo;
import com.lzpeng.minimal.common.jpa.util.JpaIdUtil;
import com.lzpeng.minimal.common.jpa.domain.entity.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.persistence.PrePersist;

/**
 * id 生成器
 * 生成规则 实体类全路径截取跟包之后 + snowflake 生成的id 并转为16进制大写
 * @author: Lzpeng
 */
@Component
public class GenerateEntityIdListener {

    @Autowired
    private Snowflake snowflake;

    private String baseEntityPackage = ProjectInfo.get().getBaseModulePackage() + ".domain.entity";

    /**
     * 实体保存前操作
     * @param target 待保存的实体
     */
    @PrePersist
    public void touchForCreate(Object target) {
        Assert.notNull(target, "Entity must not be null!");
        if (target instanceof BaseEntity) {
            BaseEntity entity = (BaseEntity) target;
            if (!entity.getClass().getPackage().getName().equals(baseEntityPackage)){
                throw new RuntimeException("请将实体类 "+ entity.getClass() +" 放至 " + baseEntityPackage + " 包下");
            }
            long longId = snowflake.nextId();
            // 编码实体id
            String entityId = JpaIdUtil.encodeEntityId(entity.getClass(), longId);
            entity.setId(entityId);
        }
    }


}
