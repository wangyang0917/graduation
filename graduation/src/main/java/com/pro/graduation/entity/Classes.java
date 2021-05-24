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
 * 班级
 * </p>
 *
 * @author hwj
 * @since 2021-05-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("classes")
@ApiModel(value="Classes对象", description="班级")
public class Classes implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "标题")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "内容")
    @TableField("remark")
    private String remark;

    @ApiModelProperty(value = "班内总人数")
    @TableField("Total")
    private long Total;

    @ApiModelProperty(value = "是否有效 1有效 2无效")
    @TableField("del_flag")
    private Integer delFlag;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

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
