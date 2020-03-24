package com.yisu.base.dao.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @description 系统用户表-实体
 * @author xuyisu
 * @date '2020-03-22 10:04:27'.
 */
@Data
@TableName("sys_user")
@EqualsAndHashCode(callSuper=false)
public class SysUser extends Model<SysUser> {

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 创建人编码
     */
    private String createUser;
    /**
     * 修改人编码
     */
    private String updateUser;
    /**
     * 删除标记(1 删除 0未删除)
     */
    @TableLogic
    private Integer deleteFlag;
    /**
     * 启用标记(1 禁用 0启用)
     */
    private Integer disableFlag;

    /**
     * 职位编码
     */
    private String posCode;
    /**
     * 头像地址
     */
    private String avatar;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 密码
     */
    private String password;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 部门编码
     */
    private String deptCode;
    /**
     * 手机号
     */
    private String userPhone;
}
