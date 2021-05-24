package com.pro.graduation.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import com.pro.graduation.utils.CommonUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户班级关系表
 * </p>
 *
 * @author hwj
 * @since 2021-05-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user_classes")
@ApiModel(value="UserClasses对象", description="用户班级关系表")
public class UserClasses implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "用户id")
    @TableField("user_id")
    private Long userId;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "是否有效 1有效 2无效")
    @TableField("del_flag")
    private Integer delFlag;

    @ApiModelProperty(value = "班级id")
    @TableField("classes_id")
    private Long classesId;


    @TableField(exist = false)
    private String createTimeDesc;

    public String getCreateTimeDesc() {
    if(CommonUtil.notNull(this.createTime)){
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    return formatter.format(this.createTime);
    }
    return "";
    }

}
