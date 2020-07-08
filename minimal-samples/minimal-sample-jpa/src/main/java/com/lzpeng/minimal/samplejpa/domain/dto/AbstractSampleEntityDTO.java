package com.lzpeng.minimal.samplejpa.domain.dto;

import com.lzpeng.minimal.common.jpa.domain.dto.BaseDTO;
import com.lzpeng.minimal.samplejpa.domain.enums.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.annotation.Generated;
import java.util.*;

/**
* AbstractSampleEntityDTO
* @author: JpaCodeGenerator
*/
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-28 20:50:57", comments = "AbstractSampleEntityDTO")
public class AbstractSampleEntityDTO extends BaseDTO{

    /**
    * 非空字段
    */
    @ApiModelProperty("非空字段")
    private String notBlank;
    /**
    * 定长字段
    */
    @ApiModelProperty("定长字段")
    private String fixedLength;

}
