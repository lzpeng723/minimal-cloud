package com.lzpeng.minimal.system.domain.dto;

import com.lzpeng.minimal.common.jpa.domain.dto.BaseDTO;
import com.lzpeng.minimal.system.domain.enums.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.annotation.Generated;
import java.util.*;

/**
* AbstractNoticeDTO
* @author: JpaCodeGenerator
*/
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-27 12:41:50", comments = "AbstractNoticeDTO")
public class AbstractNoticeDTO extends BaseDTO{

    /**
    * 通知名称
    */
    @ApiModelProperty("通知名称")
    private String name;
    /**
    * 通知编码
    */
    @ApiModelProperty("通知编码")
    private String number;
    /**
    * 通知正文
    */
    @ApiModelProperty("通知正文")
    private String content;
    /**
    * 通知类型
    */
    @ApiModelProperty("通知类型")
    private NoticeType noticeType;

}
