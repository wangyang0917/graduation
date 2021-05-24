package com.pro.graduation.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.pro.graduation.utils.CommonUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author hwj
 * @since 2021-03-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user")
@ApiModel(value="User对象", description="用户表")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "登录名 ")
    @TableField("login_name")
    private String loginName;

    @ApiModelProperty(value = "密码 ")
    @TableField("password")
    private String password;

    @ApiModelProperty(value = "用户名 ")
    @TableField("user_name")
    private String userName;

    @ApiModelProperty(value = "头像")
    @TableField("photo")
    private String photo;

    @ApiModelProperty(value = " 手机号")
    @TableField("phone")
    private String phone;

    @ApiModelProperty(value = "性别；0：保密，1：男；2：女")
    @TableField("sex")
    private String sex;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "是否有效 1有效 2无效")
    @TableField("del_flag")
    private Integer delFlag;


    @TableField("type")
    private Integer type;


    @ApiModelProperty(value = "身份证号")
    @TableField("cert_no")
    private String certNo;


    @ApiModelProperty(value = "学号")
    @TableField("code")
    private String code;

    @ApiModelProperty(value = "班级ids")
    @TableField(exist = false)
    private List<Long> classesIds;

    @ApiModelProperty(value = "班级")
    @TableField(exist = false)
    private List<Classes> classesList;


    @ApiModelProperty(value = "班级id")
    @TableField(exist = false)
    private Long classesId;


    public String getCreateTimeDesc() {
        if(CommonUtil.notNull(this.createTime)){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            return formatter.format(this.createTime);
        }
        return "";
    }


}
