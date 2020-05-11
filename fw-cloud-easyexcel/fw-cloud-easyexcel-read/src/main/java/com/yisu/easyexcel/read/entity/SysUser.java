package com.yisu.easyexcel.read.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class SysUser {

    /**
     * 职位编码
     */
    @ExcelProperty(index = 0)
    private String posCode;
    /**
     * 头像地址
     */
    @ExcelProperty(index = 1)
    private String avatar;
    /**
     * 邮箱
     */
    @ExcelProperty(index = 2)
    private String email;
    /**
     * 密码
     */
    @ExcelProperty(index = 3)
    private String password;
    /**
     * 用户名
     */
    @ExcelProperty(index = 4)
    private String userName;
    /**
     * 真实姓名
     */
    @ExcelProperty(index = 5)
    private String realName;
    /**
     * 部门编码
     */
    @ExcelProperty(index = 6)
    private String deptCode;
    /**
     * 手机号
     */
    @ExcelProperty(index = 7)
    private String userPhone;

    /**
     * 删除标记(1 删除 0未删除)
     */
    @ExcelProperty(index = 8)
    private Integer deleteFlag;
    /**
     * 启用标记(1 禁用 0启用)
     */
    @ExcelProperty(index = 9)
    private Integer disableFlag;
}
