package com.lzpeng.minimal.samplejpa;

import com.lzpeng.minimal.generate.core.AbstractCodeGenerator;
import com.lzpeng.minimal.generate.jpa.JpaCodeGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : Lzpeng
 */
class SampleJpaApplicationTest {

    @Test
    void testGenFile(){
        AbstractCodeGenerator generator = new JpaCodeGenerator();
        generator.generateAllCode();

    }

}