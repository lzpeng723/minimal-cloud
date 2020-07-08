package com.lzpeng.minimal.generate.jpa;

import com.lzpeng.minimal.common.jpa.JpaAutoConfiguration;
import com.lzpeng.minimal.generate.core.AbstractCodeGenerator;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : Lzpeng
 */
class JpaCodeGeneratorTest {

    @Test
    void genFile() throws IOException {
        AbstractCodeGenerator generator = new JpaCodeGenerator();
        generator.generateAllCode("E:\\minimal\\minimal-cloud\\minimal-common\\minimal-common-jpa",JpaAutoConfiguration.class);
    }

}