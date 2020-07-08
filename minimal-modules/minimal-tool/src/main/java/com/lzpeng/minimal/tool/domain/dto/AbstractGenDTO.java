package com.lzpeng.minimal.tool.domain.dto;

import com.lzpeng.minimal.common.jpa.domain.dto.BaseDTO;
import com.lzpeng.minimal.tool.domain.enums.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.annotation.Generated;
import java.util.*;

/**
* AbstractGenDTO
* @author: JpaCodeGenerator
*/
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-27 23:21:56", comments = "AbstractGenDTO")
public class AbstractGenDTO extends BaseDTO{

    /**
    * 模板名称
    */
    @ApiModelProperty("模板名称")
    private String name;
    /**
    * 模板编码
    */
    @ApiModelProperty("模板编码")
    private String number;
    /**
    * 生成路径
    */
    @ApiModelProperty("生成路径")
    private String path;
    /**
    * 模板文件
    */
    @ApiModelProperty("模板文件")
    private String template;
    /**
    * 默认是否覆盖生成
    */
    @ApiModelProperty("默认是否覆盖生成")
    private Boolean override;
    /**
    * 生成文件类型
    */
    @ApiModelProperty("生成文件类型")
    private GenFileType type;

}
