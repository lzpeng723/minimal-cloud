package com.lzpeng.minimal.demo.domain.dto;

import com.lzpeng.minimal.common.jpa.domain.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.annotation.Generated;
import java.util.*;

/**
* AbstractDemoEntityDTO
* @author: JpaCodeGenerator
*/
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-7-7 18:31:21", comments = "AbstractDemoEntityDTO")
public class AbstractDemoEntityDTO extends BaseDTO{

    /**
    * 名称
    */
    @ApiModelProperty("名称")
    private String name;
    /**
    * 编码
    */
    @ApiModelProperty("编码")
    private String number;

}
