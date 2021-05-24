package com.pro.graduation.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pro.graduation.utils.CommonUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 书籍信息
 * </p>
 *
 * @author hwj
 * @since 2021-05-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("appointment")
@ApiModel(value="Appointment对象", description="书籍信息")
public class Appointment implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "是否有效 1有效 2无效")
    @TableField("del_flag")
    private Integer delFlag;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "预约人id")
    @TableField("user_id")
    private Long userId;

    @TableField(exist = false)
    private User user;

    @ApiModelProperty(value = "开始时间")
    @TableField("start_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;

    @ApiModelProperty(value = "是否有效 1待审批 2审批通过 3审批不通过")
    @TableField("status")
    private Integer status;

    @ApiModelProperty(value = "课程名称")
    @TableField("lesson")
    private String lesson;

    @ApiModelProperty(value = "结束时间")
    @TableField("end_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;

    @ApiModelProperty(value = "教材名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "图片")
    @TableField("photo")
    private String photo;

    @ApiModelProperty(value = "教材名称")
    @TableField("remark")
    private String remark;

    @ApiModelProperty(value = "图书id")
    @TableField("book_id")
    private Long bookId;

    @ApiModelProperty(value = "订购总人数")
    @TableField("Total")
    private Long Total;

    @TableField(exist =  false)
    private Book book;

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
