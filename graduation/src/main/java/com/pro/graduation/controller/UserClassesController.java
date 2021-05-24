package com.pro.graduation.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pro.graduation.entity.UserClasses;
import com.pro.graduation.service.IUserClassesService;
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

/**
 * <p>
 * 用户班级关系表 前端控制器
 * </p>
 *
 * @author hwj
 * @since 2021-05-09
 */
@RestController
@RequestMapping("/userClasses")
@Api(value = "UserClassesController",tags = "用户班级关系表接口")
public class UserClassesController {

@Autowired
IUserClassesService userClassesService;

@GetMapping(value = "/getPageList")
@ApiOperation(value = "分页列表", notes = "分页列表")
public ResultHelp getPageList(RequestHelp requestHelp) {
   Page<UserClasses> page = new Page(requestHelp.getPage(), requestHelp.getPageSize());
   Map params = requestHelp.apply();
   QueryWrapper<UserClasses> query = new QueryWrapper<UserClasses>();
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
      if(CommonUtil.notNull(params.get("classesId"))){
      query.eq("classes_id",params.get("classesId"));
      }
   page = userClassesService.page(page,query);
   return CommonUtil.getResultHelp(page);

   }


@GetMapping(value = "/getAllList")
@ApiOperation(value = "全部列表", notes = "全部列表")
public ResultHelp getALLList(RequestHelp requestHelp) {
     Map params = requestHelp.apply();
     QueryWrapper<UserClasses> query = new QueryWrapper<UserClasses>();

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
        if(CommonUtil.notNull(params.get("classesId"))){
        query.eq("classes_id",params.get("classesId"    ));
        }
     List<UserClasses> list = userClassesService.list(query);
      return new ResultHelp(list);
 }



@PostMapping(value = "/add")
@ApiOperation(value = "新增", notes = "新增")
public SimpleResultHelp<UserClasses> add(@RequestBody UserClasses userClasses) {
    Map< String, Object> maps = new HashMap<>();
    SimpleResultHelp simpleResultHelp = new SimpleResultHelp(null);
    userClasses.setCreateTime(LocalDateTime.now());
    userClassesService.saveOrUpdate(userClasses);
    return simpleResultHelp;
    }


    @PostMapping(value = "/edit")
    @ApiOperation(value = "修改", notes = "修改")
    public SimpleResultHelp<UserClasses> edit(@RequestBody UserClasses userClasses) {
        Map< String, Object> maps = new HashMap<>();
        SimpleResultHelp simpleResultHelp = new SimpleResultHelp(null);
    userClassesService.saveOrUpdate(userClasses);
        return simpleResultHelp;
        }


   @PostMapping(value = "/delById/{id}")
   @ApiOperation(value = "根据id删除", notes = "根据id删除")
   public SimpleResultHelp<Boolean> delById(@PathVariable("id") Integer id) {

    UpdateWrapper<UserClasses> wrapper = new UpdateWrapper<>();
        wrapper.set("del_flag",2);
        wrapper.eq("id",id);
        return new SimpleResultHelp(userClassesService.update(wrapper));
    }


    @PostMapping(value = "/delByIds")
    @ApiOperation(value = "批量删除", notes = "批量删除")
    public SimpleResultHelp<Boolean> delByIds(@RequestBody Map ids) {
        return new SimpleResultHelp(userClassesService.removeByIds((List<String>) (ids.get("ids"))));
            }

        }
