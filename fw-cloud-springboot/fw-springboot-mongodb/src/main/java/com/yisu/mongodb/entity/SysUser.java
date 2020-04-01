package com.yisu.mongodb.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/**
 * @description 系统用户表-实体
 * @author xuyisu
 * @date '2020-03-22 10:04:27'.
 */
@Data
@Document(collection = "sys_user")
@EqualsAndHashCode(callSuper=false)
public class SysUser {

    /**
     * 主键
     */
    @Id
    private Long id;
    /**
     * 创建时间
     */
    @Field("create_time")
    private Date createTime;
    /**
     * 更新时间
     */
    @Field("update_time")
    private Date updateTime;
    /**
     * 创建人编码
     */
    @Field("create_user")
    private String createUser;
    /**
     * 修改人编码
     */
    @Field("update_user")
    private String updateUser;
    /**
     * 删除标记(1 删除 0未删除)
     */
    @Field("delete_flag")
    private Integer deleteFlag;
    /**
     * 启用标记(1 禁用 0启用)
     */
    @Field("disable_flag")
    private Integer disableFlag;

    /**
     * 职位编码
     */
    @Field("pos_code")
    private String posCode;
    /**
     * 头像地址
     */
    @Field("avatar")
    private String avatar;
    /**
     * 邮箱
     */
    @Field("email")
    private String email;
    /**
     * 密码
     */
    @Field("password")
    private String password;
    /**
     * 用户名
     */
    @Field("user_name")
    private String userName;
    /**
     * 真实姓名
     */
    @Field("real_name")
    private String realName;
    /**
     * 部门编码
     */
    @Field("dept_code")
    private String deptCode;
    /**
     * 手机号
     */
    @Field("user_phone")
    private String userPhone;
}
