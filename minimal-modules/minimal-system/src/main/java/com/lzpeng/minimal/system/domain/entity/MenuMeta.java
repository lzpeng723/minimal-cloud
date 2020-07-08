package com.lzpeng.minimal.system.domain.entity;

import com.lzpeng.minimal.common.core.annotation.GenerateCode;
import com.lzpeng.minimal.common.jpa.domain.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author:   Lzpeng
 */
@Data
@ApiModel("菜单详细信息")
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@GenerateCode(generate = false)
public class MenuMeta extends BaseEntity {

    
    @ApiModelProperty("标题")
    private String title;

    
    @ApiModelProperty("图标")
    private String icon;

    
    @ApiModelProperty("是否缓存")
    private Boolean noCache;

    
    @ApiModelProperty("是否固定在tagsView")
    private Boolean affix;

    
    @ApiModelProperty("是否在面包屑中显示")
    private Boolean breadcrumb;

    
    @ApiModelProperty("高亮显示路由")
    private String activeMenu;
}
