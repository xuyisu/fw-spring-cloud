package com.yisu.swagger.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * 系统用户表-实体
 * @author xuyisu
 * @date '2019-10-17 19:25:49'.
 */
@Data
public class SysUser {

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String userName;
    /**
     * 真实姓名
     */
    @ApiModelProperty(value = "真实姓名")
    private String realName;
    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String userPhone;
}
