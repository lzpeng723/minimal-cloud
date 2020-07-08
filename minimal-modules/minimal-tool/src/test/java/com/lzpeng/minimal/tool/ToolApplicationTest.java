package com.lzpeng.minimal.tool;



import com.lzpeng.minimal.generate.core.AbstractCodeGenerator;
import com.lzpeng.minimal.generate.jpa.JpaCodeGenerator;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : Lzpeng
 */
class ToolApplicationTest {

    @Test
    void genFile() throws IOException {
        AbstractCodeGenerator generator = new JpaCodeGenerator();
        generator.generateAllCode();
    }

}