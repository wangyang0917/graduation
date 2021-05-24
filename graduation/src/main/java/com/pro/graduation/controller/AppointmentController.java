package com.pro.graduation.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pro.graduation.entity.Appointment;
import com.pro.graduation.entity.Book;
import com.pro.graduation.entity.User;
import com.pro.graduation.entity.UserClasses;
import com.pro.graduation.service.IAppointmentService;
import com.pro.graduation.service.IBookService;
import com.pro.graduation.service.IUserClassesService;
import com.pro.graduation.service.IUserService;
import com.pro.graduation.utils.CommonUtil;
import com.pro.graduation.utils.RequestHelp;
import com.pro.graduation.utils.ResultHelp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.pro.graduation.utils.SimpleResultHelp;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

/**
 * <p>
 * 书籍信息 前端控制器
 * </p>
 *
 * @author hwj
 * @since 2021-05-09
 */
@RestController
@RequestMapping("/appointment")
@Api(value = "AppointmentController",tags = "书籍信息接口")
public class AppointmentController {

@Autowired
IAppointmentService appointmentService;


    @Autowired
    IBookService bookService;


    @Autowired
    IUserService userService;

    @Autowired
    IUserClassesService userClassesService;

@GetMapping(value = "/getPageList")
@ApiOperation(value = "分页列表", notes = "分页列表")
public ResultHelp getPageList(RequestHelp requestHelp) {
   Page<Appointment> page = new Page(requestHelp.getPage(), requestHelp.getPageSize());
   Map params = requestHelp.apply();
   QueryWrapper<Appointment> query = new QueryWrapper<Appointment>();
    if (CommonUtil.notNull(params.get("id"))) {
        query.eq("id", params.get("id"));
    }
    if (CommonUtil.notNull(params.get("delFlag"))) {
        query.eq("del_flag", params.get("delFlag"));
    }
    if (CommonUtil.notNull(params.get("createTime"))) {
        query.eq("create_time", params.get("createTime"));
    }
    if (CommonUtil.notNull(params.get("userId"))) {
        query.eq("user_id", params.get("userId"));
    }
    if (CommonUtil.notNull(params.get("startTime"))) {
        query.eq("start_time", params.get("startTime"));
    }
    if (CommonUtil.notNull(params.get("status"))) {
        query.eq("status", params.get("status"));
    }
    if (CommonUtil.notNull(params.get("lesson"))) {
        query.eq("lesson", params.get("lesson"));
    }
    if (CommonUtil.notNull(params.get("endTime"))) {
        query.eq("end_time", params.get("endTime"));
    }
    if (CommonUtil.notNull(params.get("name"))) {
        query.eq("name", params.get("name"));
    }
    if (CommonUtil.notNull(params.get("remark"))) {
        query.eq("remark", params.get("remark"));
    }
    if (CommonUtil.notNull(params.get("bookId"))) {
        query.eq("book_id", params.get("bookId"));
    }
    if (CommonUtil.notNull(params.get("Total"))) {
        query.eq("Total", params.get("Total"));
    }
    if(CommonUtil.notNull(params.get("stuId"))){
        QueryWrapper<UserClasses> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",params.get("stuId"));
        queryWrapper.eq("del_flag",1);
        List<UserClasses> userClassesList = userClassesService.list(queryWrapper);
        if(userClassesList.size()>0){
            QueryWrapper<UserClasses> teacherQuery = new QueryWrapper<>();
            teacherQuery.in("classes_id", userClassesList.stream().map(mit->mit.getClassesId()).distinct().collect(Collectors.toList()));
            teacherQuery.eq("del_flag",1);
            List<UserClasses> teacherClassesList = userClassesService.list(teacherQuery);
            if(teacherClassesList.size()>0){
                query.in("user_id",teacherClassesList.stream().map(mit->mit.getUserId()).distinct().collect(Collectors.toList()));
            }
        }
    }
   page = appointmentService.page(page,query);

    page.getRecords().stream().forEach(it -> {
        User user = userService.getById(it.getUserId());
        it.setUser(user);
        Book book = bookService.getById(it.getBookId());
        it.setBook(book);

    });

   return CommonUtil.getResultHelp(page);

   }


@GetMapping(value = "/getAllList")
@ApiOperation(value = "全部列表", notes = "全部列表")
public ResultHelp getALLList(RequestHelp requestHelp) {
     Map params = requestHelp.apply();
     QueryWrapper<Appointment> query = new QueryWrapper<Appointment>();

        if(CommonUtil.notNull(params.get("id"))){
        query.eq("id",params.get("id"));
        }
        if(CommonUtil.notNull(params.get("delFlag"))){
        query.eq("del_flag",params.get("delFlag"));
        }
        if(CommonUtil.notNull(params.get("createTime"))){
        query.eq("create_time",params.get("createTime"));
        }
        if(CommonUtil.notNull(params.get("userId"))){
        query.eq("user_id",params.get("userId"));
        }
        if(CommonUtil.notNull(params.get("startTime"))){
        query.eq("start_time",params.get("startTime"));
        }
        if(CommonUtil.notNull(params.get("status"))){
        query.eq("status",params.get("status"));
        }
        if(CommonUtil.notNull(params.get("endTime"))){
        query.eq("end_time",params.get("endTime"));
        }
        if(CommonUtil.notNull(params.get("name"))){
        query.eq("name",params.get("name"));
        }
        if(CommonUtil.notNull(params.get("remark"))){
        query.eq("remark",params.get("remark"));
        }
        if(CommonUtil.notNull(params.get("bookId"))){
        query.eq("book_id",params.get("bookId"));
        }
    if(CommonUtil.notNull(params.get("stuId"))){
         QueryWrapper<UserClasses> queryWrapper = new QueryWrapper<>();
         queryWrapper.eq("user_id",params.get("stuId"));
        queryWrapper.eq("del_flag",1);
         List<UserClasses> userClassesList = userClassesService.list(queryWrapper);
         if(userClassesList.size()>0){
             QueryWrapper<UserClasses> teacherQuery = new QueryWrapper<>();
             teacherQuery.in("classes_id", userClassesList.stream().map(mit->mit.getClassesId()).distinct().collect(Collectors.toList()));
             teacherQuery.eq("del_flag",1);
             List<UserClasses> teacherClassesList = userClassesService.list(teacherQuery);
             if(teacherClassesList.size()>0){
                 query.in("user_id",teacherClassesList.stream().map(mit->mit.getUserId()).distinct().collect(Collectors.toList()));
             }
         }
    }
     List<Appointment> list = appointmentService.list(query);


    list.stream().forEach(it -> {
        User user = userService.getById(it.getUserId());
        it.setUser(user);
        Book book = bookService.getById(it.getBookId());
        it.setBook(book);

    });
      return new ResultHelp(list);
 }



@PostMapping(value = "/add")
@ApiOperation(value = "新增", notes = "新增")
public SimpleResultHelp<Appointment> add(@RequestBody Appointment appointment) {
    Map< String, Object> maps = new HashMap<>();
    SimpleResultHelp simpleResultHelp = new SimpleResultHelp(null);
    appointment.setCreateTime(LocalDateTime.now());
    appointmentService.saveOrUpdate(appointment);
    return simpleResultHelp;
    }


    @PostMapping(value = "/edit")
    @ApiOperation(value = "修改", notes = "修改")
    public SimpleResultHelp<Appointment> edit(@RequestBody Appointment appointment) {
        Map< String, Object> maps = new HashMap<>();
        SimpleResultHelp simpleResultHelp = new SimpleResultHelp(null);
    appointmentService.saveOrUpdate(appointment);
        return simpleResultHelp;
        }


   @PostMapping(value = "/delById/{id}")
   @ApiOperation(value = "根据id删除", notes = "根据id删除")
   public SimpleResultHelp<Boolean> delById(@PathVariable("id") Integer id) {

    UpdateWrapper<Appointment> wrapper = new UpdateWrapper<>();
        wrapper.set("del_flag",2);
        wrapper.eq("id",id);
        return new SimpleResultHelp(appointmentService.update(wrapper));
    }


    @PostMapping(value = "/delByIds")
    @ApiOperation(value = "批量删除", notes = "批量删除")
    public SimpleResultHelp<Boolean> delByIds(@RequestBody Map ids) {
        return new SimpleResultHelp(appointmentService.removeByIds((List<String>) (ids.get("ids"))));
            }

        }
