package com.pro.graduation.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pro.graduation.entity.Appointment;
import com.pro.graduation.entity.Book;
import com.pro.graduation.entity.User;
import com.pro.graduation.entity.UserAppointment;
import com.pro.graduation.service.IAppointmentService;
import com.pro.graduation.service.IUserAppointmentService;
import com.pro.graduation.service.IUserService;
import com.pro.graduation.utils.CommonUtil;
import com.pro.graduation.utils.RequestHelp;
import com.pro.graduation.utils.ResultHelp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.pro.graduation.utils.SimpleResultHelp;

import java.time.ZoneOffset;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户班级关系表 前端控制器
 * </p>
 *
 * @author hwj
 * @since 2021-05-09
 */
@RestController
@RequestMapping("/userAppointment")
@Api(value = "UserAppointmentController",tags = "用户班级关系表接口")
public class UserAppointmentController {

@Autowired
IUserAppointmentService userAppointmentService;

    @Autowired
    IAppointmentService appointmentService;


    @Autowired
    IUserService userService;

@GetMapping(value = "/getPageList")
@ApiOperation(value = "分页列表", notes = "分页列表")
public ResultHelp getPageList(RequestHelp requestHelp) {
   Page<UserAppointment> page = new Page(requestHelp.getPage(), requestHelp.getPageSize());
   Map params = requestHelp.apply();
   QueryWrapper<UserAppointment> query = new QueryWrapper<UserAppointment>();
      if(CommonUtil.notNull(params.get("id"))){
      query.eq("id",params.get("id"));
      }
      if(CommonUtil.notNull(params.get("userId"))){
      query.eq("user_id",params.get("userId"));
      }
      if(CommonUtil.notNull(params.get("createTime"))){
      query.eq("create_time",params.get("createTime"));
      }
      if(CommonUtil.notNull(params.get("delFlag"))){
      query.eq("del_flag",params.get("delFlag"));
      }
      if(CommonUtil.notNull(params.get("appointmentId"))){
      query.eq("appointment_id",params.get("appointmentId"));
      }
   page = userAppointmentService.page(page,query);
    page.getRecords().stream().forEach(it -> {
        User user = userService.getById(it.getUserId());
        it.setUser(user);
        Appointment appointment = appointmentService.getById(it.getAppointmentId());
        it.setAppointment(appointment);

    });
   return CommonUtil.getResultHelp(page);

   }


@GetMapping(value = "/getAllList")
@ApiOperation(value = "全部列表", notes = "全部列表")
public ResultHelp getALLList(RequestHelp requestHelp) {
     Map params = requestHelp.apply();
     QueryWrapper<UserAppointment> query = new QueryWrapper<UserAppointment>();

    if (CommonUtil.notNull(params.get("id"))) {
        query.eq("id", params.get("id"));
    }
    if (CommonUtil.notNull(params.get("userId"))) {
        query.eq("user_id", params.get("userId"));
    }
    if (CommonUtil.notNull(params.get("createTime"))) {
        query.eq("create_time", params.get("createTime"));
    }
    if (CommonUtil.notNull(params.get("delFlag"))) {
        query.eq("del_flag", params.get("delFlag"));
    }
    if (CommonUtil.notNull(params.get("appointmentId"))) {
        query.eq("appointment_id", params.get("appointmentId"));
    }
     List<UserAppointment> list = userAppointmentService.list(query);
    list.stream().forEach(it -> {
        User user = userService.getById(it.getUserId());
        it.setUser(user);
        Appointment appointment = appointmentService.getById(it.getAppointmentId());
        it.setAppointment(appointment);

    });


      return new ResultHelp(list);
 }



@PostMapping(value = "/add")
@ApiOperation(value = "新增", notes = "新增")
public SimpleResultHelp<UserAppointment> add(@RequestBody UserAppointment userAppointment) {
    Map< String, Object> maps = new HashMap<>();
    SimpleResultHelp simpleResultHelp = new SimpleResultHelp(null);
    if(CommonUtil.notNull(userAppointment.getAppointmentId())){
        Appointment appointment = appointmentService.getById(userAppointment.getAppointmentId());
        if(appointment.getStartTime().toInstant(ZoneOffset.of("+8")).toEpochMilli() > LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli()){
           return SimpleResultHelp.result("9999","时间未开始");
        }

        if(appointment.getEndTime().toInstant(ZoneOffset.of("+8")).toEpochMilli() < LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli()){
            return SimpleResultHelp.result("9999","时间已结束");
        }
        QueryWrapper<UserAppointment> userAppointmentQueryWrapper = new QueryWrapper<>();
        userAppointmentQueryWrapper.eq("appointment_id",userAppointment.getAppointmentId());
        userAppointmentQueryWrapper.eq("user_id",userAppointment.getUserId());
        int count = userAppointmentService.count(userAppointmentQueryWrapper);
        if(count >0){
            return SimpleResultHelp.result("9999","您已订购，请勿重复订购");
        }
    }
    userAppointment.setCreateTime(LocalDateTime.now());
    userAppointmentService.saveOrUpdate(userAppointment);
    return simpleResultHelp;
    }


    @PostMapping(value = "/edit")
    @ApiOperation(value = "修改", notes = "修改")
    public SimpleResultHelp<UserAppointment> edit(@RequestBody UserAppointment userAppointment) {
        Map< String, Object> maps = new HashMap<>();
        SimpleResultHelp simpleResultHelp = new SimpleResultHelp(null);
    userAppointmentService.saveOrUpdate(userAppointment);
        return simpleResultHelp;
        }


   @PostMapping(value = "/delById/{id}")
   @ApiOperation(value = "根据id删除", notes = "根据id删除")
   public SimpleResultHelp<Boolean> delById(@PathVariable("id") Integer id) {

    UpdateWrapper<UserAppointment> wrapper = new UpdateWrapper<>();
        wrapper.set("del_flag",2);
        wrapper.eq("id",id);
        return new SimpleResultHelp(userAppointmentService.update(wrapper));
    }


    @PostMapping(value = "/delByIds")
    @ApiOperation(value = "批量删除", notes = "批量删除")
    public SimpleResultHelp<Boolean> delByIds(@RequestBody Map ids) {
        return new SimpleResultHelp(userAppointmentService.removeByIds((List<String>) (ids.get("ids"))));
            }

        }
