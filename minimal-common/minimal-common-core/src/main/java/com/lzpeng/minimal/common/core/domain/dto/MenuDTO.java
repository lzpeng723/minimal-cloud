package com.lzpeng.minimal.common.core.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 菜单
 * @author : Lzpeng
 */
@Data
public class MenuDTO {

    /**
     * 权限菜单名称
     */
    @ApiModelProperty("权限菜单名称")
    private String name;
    /**
     * 权限编码
     */
    @ApiModelProperty("权限编码")
    private String number;
    /**
     * 菜单对应前端路由
     */
    @ApiModelProperty("菜单对应前端路由")
    private String path;
    /**
     * 菜单重定向路由
     */
    @ApiModelProperty("菜单重定向路由")
    private String redirect;
    /**
     * 按钮菜单是否隐藏
     */
    @ApiModelProperty("按钮菜单是否隐藏")
    private Boolean hidden;
    /**
     * 当下级只有一个子路由时是否显示菜单
     */
    @ApiModelProperty("当下级只有一个子路由时是否显示菜单")
    private Boolean alwaysShow;
    /**
     * 菜单对应Vue组件路径
     */
    @ApiModelProperty("菜单对应Vue组件路径")
    private String component;
    /**
     * 是否外链
     */
    @ApiModelProperty("是否外链")
    private Boolean frame;
    /**
     * 按钮对应后端功能url
     */
    @ApiModelProperty("按钮对应后端功能url")
    private String function;
    /**
     * 权限菜单类型
     */
    @ApiModelProperty("权限菜单类型")
    private Integer type;
    /**
     * 标题
     */
    @ApiModelProperty("标题")
    private String title;
    /**
     * 图标
     */
    @ApiModelProperty("图标")
    private String icon;
    /**
     * 是否缓存
     */
    @ApiModelProperty("是否缓存")
    private Boolean noCache;
    /**
     * 是否固定在tagsView
     */
    @ApiModelProperty("是否固定在tagsView")
    private Boolean affix;
    /**
     * 是否在面包屑中显示
     */
    @ApiModelProperty("是否在面包屑中显示")
    private Boolean breadcrumb;
    /**
     * 高亮显示路由
     */
    @ApiModelProperty("高亮显示路由")
    private String activeMenu;
}
