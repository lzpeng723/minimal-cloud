package com.lzpeng.minimal.generate.core;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 代码生成配置
 * @author : Lzpeng
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenConfig {

    /**
     * 代码生成路径
     */
    private String path;

    /**
     * 代码模板
     */
    private String template;

    /**
     * 是否覆盖生成
     */
    private Boolean override;

}
