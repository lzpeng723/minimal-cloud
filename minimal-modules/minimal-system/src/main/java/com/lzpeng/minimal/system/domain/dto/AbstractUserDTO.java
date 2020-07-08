package com.lzpeng.minimal.system.domain.dto;

import com.lzpeng.minimal.common.jpa.domain.dto.LeftTreeRightTableDTO;
import com.lzpeng.minimal.system.domain.enums.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.annotation.Generated;
import java.util.*;

/**
* AbstractUserDTO
* @author: JpaCodeGenerator
*/
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Generated(value = "com.lzpeng.minimal.generate.jpa.JpaCodeGenerator", date = "2020-6-27 12:41:50", comments = "AbstractUserDTO")
public class AbstractUserDTO extends LeftTreeRightTableDTO{

    /**
    * 用户名
    */
    @ApiModelProperty("用户名")
    private String username;
    /**
    * 密码
    */
    @ApiModelProperty("密码")
    private String password;
    /**
    * 手机号
    */
    @ApiModelProperty(example = "137xxxxxxxx", value = "手机号")
    private String mobile;
    /**
    * 邮箱
    */
    @ApiModelProperty(example = "xxxxxxx@qq.com", value = "邮箱")
    private String email;
    /**
    * 用户头像
    */
    @ApiModelProperty(example = "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif", value = "用户头像")
    private String avatar;
    /**
    * 用户真实姓名
    */
    @ApiModelProperty(example = "张三", value = "用户真实姓名")
    private String name;
    /**
    * 用户自我介绍
    */
    @ApiModelProperty("用户自我介绍")
    private String introduction;
    /**
    * 最后登录时间
    */
    @ApiModelProperty(hidden = true, value = "最后登录时间")
    private Date lastLoginTime;
    /**
    * 账户是否未过期
    */
    @ApiModelProperty(hidden = true, value = "账户是否未过期")
    private boolean accountNonExpired;
    /**
    * 账户是否未冻结
    */
    @ApiModelProperty(hidden = true, value = "账户是否未冻结")
    private boolean accountNonLocked;
    /**
    * 密码是否未过期
    */
    @ApiModelProperty(hidden = true, value = "密码是否未过期")
    private boolean credentialsNonExpired;
    /**
    * 账户是否未删除
    */
    @ApiModelProperty(hidden = true, value = "账户是否未删除")
    private boolean enabled;

}
