package com.lzpeng.minimal.system.domain.dto;

import com.lzpeng.minimal.common.jpa.domain.dto.BaseDTO;
import com.lzpeng.minimal.system.domain.enums.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.annotation.Generated;
import java.util.*;

/**
* AbstractNotificationRecordDTO
* @author: JpaCodeGenerator
*/
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-27 12:41:50", comments = "AbstractNotificationRecordDTO")
public class AbstractNotificationRecordDTO extends BaseDTO{

    /**
    * 发送者
    */
    @ApiModelProperty(hidden = true, value = "发送者")
    private UserDTO sender;
    /**
    * 通知
    */
    @ApiModelProperty(hidden = true, value = "通知")
    private NoticeDTO notice;
    /**
    * 接收者
    */
    @ApiModelProperty(hidden = true, value = "接收者")
    private UserDTO receiver;
    /**
    * 是否已读
    */
    @ApiModelProperty("是否已读")
    private Boolean view;

}
