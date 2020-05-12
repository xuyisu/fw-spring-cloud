package com.yisu.easyexcel.write.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.yisu.easyexcel.write.converter.DeleteConverter;
import com.yisu.easyexcel.write.converter.DisabledConverter;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@TableName("sys_user")
@EqualsAndHashCode(callSuper=false)
public class SysUser extends Model<SysUserBak> {

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.ID_WORKER)
    @ExcelIgnore
    private Long id;
    /**
     * 创建时间
     */
    @ExcelProperty("创建时间")
    @DateTimeFormat("yyyy年MM月dd日HH时mm分ss秒")
    private Date createTime;
    /**
     * 更新时间
     */
    @ExcelIgnore
    private Date updateTime;
    /**
     * 创建人编码
     */
    @ExcelIgnore
    private String createUser;
    /**
     * 修改人编码
     */
    @ExcelIgnore
    private String updateUser;

    /**
     * 职位编码
     */
    @ExcelProperty("职位编码")
    private String posCode;
    /**
     * 头像地址
     */
    @ExcelProperty("头像地址")
    private String avatar;
    /**
     * 邮箱
     */
    @ExcelProperty("邮箱")
    private String email;
    /**
     * 密码
     */
    @ExcelProperty("密码")
    private String password;
    /**
     * 用户名
     */
    @ExcelProperty("用户名")
    private String userName;
    /**
     * 真实姓名
     */
    @ExcelProperty("真实姓名")
    private String realName;
    /**
     * 部门编码
     */
    @ExcelProperty("部门编码")
    private String deptCode;
    /**
     * 手机号
     */
    @ExcelProperty("手机号")
    private String userPhone;

    /**
     * 删除标记(1 删除 0未删除)
     */
    @ExcelProperty(value = "删除标记",converter = DeleteConverter.class)
    private Integer deleteFlag;
    /**
     * 启用标记(1 禁用 0启用)
     */
    @ExcelProperty(value = "启用标记",converter = DisabledConverter.class)
    private Integer disableFlag;
}
