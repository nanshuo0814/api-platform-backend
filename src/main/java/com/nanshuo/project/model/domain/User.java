package com.nanshuo.project.model.domain;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户实体类
 *
 * @author nanshuo
 * @TableName user
 * @date 2024/01/04 14:43:30
 */
@Data
@TableName(value ="user")
@ApiModel(value = "User", description = "用户实体类")
public class User implements Serializable {

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户ID")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 用户账号
     */
    @ApiModelProperty(value = "用户账号")
    @TableField(value = "userAccount")
    private String userAccount;

    /**
     * 用户密码
     */
    @ApiModelProperty(value = "用户密码")
    @TableField(value = "userPassword")
    private String userPassword;

    /**
     * 用户昵称
     */
    @ApiModelProperty(value = "用户昵称")
    @TableField(value = "userName")
    private String userName;

    /**
     * 0-女，1-男，2-未知
     */
    @ApiModelProperty(value = "0-女，1-男，2-未知")
    @TableField(value = "userGender")
    private Integer userGender;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    @TableField(value = "userEmail")
    private String userEmail;

    /**
     * 用户头像
     */
    @ApiModelProperty(value = "用户头像")
    @TableField(value = "userAvatar")
    private String userAvatar;

    /**
     * 用户简介
     */
    @ApiModelProperty(value = "用户简介")
    @TableField(value = "userProfile")
    private String userProfile;

    /**
     * 用户角色：user/admin/ban
     */
    @ApiModelProperty(value = "用户角色：user/admin/ban")
    @TableField(value = "userRole")
    private String userRole;

    /**
     * accessKey
     */
    @ApiModelProperty(value = "accessKey")
    @TableField(value = "accessKey")
    private String accessKey;

    /**
     * secretKey
     */
    @ApiModelProperty(value = "secretKey")
    @TableField(value = "secretKey")
    private String secretKey;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @TableField(value = "createTime")
    private Date createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    @TableField(value = "updateTime")
    private Date updateTime;

    /**
     * 是否删除，0:默认，1:删除
     */
    @ApiModelProperty(value = "是否删除，0:默认，1:删除")
    @TableField(value = "isDelete")
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}