package com.lzpeng.minimal.demo;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.lzpeng.minimal.common.jpa.util.JpaIdUtil;
import com.lzpeng.minimal.demo.domain.entity.DemoEntity;
import com.lzpeng.minimal.generate.core.AbstractCodeGenerator;
import com.lzpeng.minimal.generate.jpa.JpaCodeGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : Lzpeng
 */
class DemoApplicationTest {

    @Test
    void testGenFile(){
        AbstractCodeGenerator generator = new JpaCodeGenerator();
        generator.generateAllCode();
    }

}