package com.pro.graduation.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pro.graduation.entity.Classes;
import com.pro.graduation.entity.User;
import com.pro.graduation.entity.UserClasses;
import com.pro.graduation.service.IClassesService;
import com.pro.graduation.service.IUserClassesService;
import com.pro.graduation.service.IUserService;
import com.pro.graduation.utils.CommonUtil;
import com.pro.graduation.utils.RequestHelp;
import com.pro.graduation.utils.ResultHelp;
import com.pro.graduation.utils.SimpleResultHelp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author hwj
 * @since 2021-03-06
 */
@RestController
@RequestMapping("/user")
@Api(value = "UserController", tags = "用户表接口")
public class UserController {

    @Autowired
    IUserService userService;


    @Autowired
    IUserClassesService userClassesService;

    @Autowired
    IClassesService classesService;

    @GetMapping(value = "/getPageList")
    @ApiOperation(value = "分页列表", notes = "分页列表")
    public ResultHelp getPageList(RequestHelp requestHelp) {
        Page<User> page = new Page(requestHelp.getPage(), requestHelp.getPageSize());
        Map params = requestHelp.apply();
        QueryWrapper<User> query = new QueryWrapper<User>();
        if (null != params.get("userName")) {
            query.like("user_name", params.get("userName"));
        }
        if (CommonUtil.notNull(params.get("type"))) {
            query.eq("type", params.get("type"));
        }
        if (null != params.get("status")) {
            query.eq("status", params.get("status"));
        }
        page = userService.page(page, query);
        page.getRecords().stream().forEach(it->{
            QueryWrapper<UserClasses> userClassesQueryWrapper = new QueryWrapper<>();
            userClassesQueryWrapper.eq("user_id",it.getId());
            userClassesQueryWrapper.eq("del_flag",1);
            List<UserClasses> userClassesList = userClassesService.list(userClassesQueryWrapper);
            if(userClassesList.size()>0){
                QueryWrapper<Classes> classesQueryWrapper = new QueryWrapper<>();
                classesQueryWrapper.in("id",  userClassesList.stream().map(mit->mit.getClassesId()).distinct().collect(Collectors.toList()));
                classesQueryWrapper.eq("del_flag",1);
                List<Classes> classesList = classesService.list(classesQueryWrapper);
                it.setClassesList(classesList);
                it.setClassesIds(userClassesList.stream().map(mit->mit.getId()).distinct().collect(Collectors.toList()));
            }
         });

        return CommonUtil.getResultHelp(page);
    }


    @GetMapping(value = "/getAllList")
    @ApiOperation(value = "全部列表", notes = "全部列表")
    public ResultHelp getALLList(RequestHelp requestHelp) {
        Map params = requestHelp.apply();
        QueryWrapper<User> query = new QueryWrapper<User>();
        if (null != params.get("userName")) {
            query.like("user_name", params.get("userName"));
        }
        if (CommonUtil.notNull(params.get("type"))) {
            query.eq("type", params.get("type"));
        }
        if (null != params.get("status")) {
            query.eq("status", params.get("status"));
        }
        List<User> list = userService.list(query);
        list.stream().forEach(it->{
            QueryWrapper<UserClasses> userClassesQueryWrapper = new QueryWrapper<>();
            userClassesQueryWrapper.eq("user_id",it.getId());
            userClassesQueryWrapper.eq("del_flag",1);
            List<UserClasses> userClassesList = userClassesService.list(userClassesQueryWrapper);
            if(userClassesList.size()>0){
                QueryWrapper<Classes> classesQueryWrapper = new QueryWrapper<>();
                classesQueryWrapper.in("id",  userClassesList.stream().map(mit->mit.getClassesId()).distinct().collect(Collectors.toList()));
                classesQueryWrapper.eq("del_flag",1);
                List<Classes> classesList = classesService.list(classesQueryWrapper);
                it.setClassesList(classesList);
                it.setClassesIds(userClassesList.stream().map(mit->mit.getId()).distinct().collect(Collectors.toList()));
            }
        });
        return new ResultHelp(list);
    }


    @PostMapping(value = "/registUser")
    @ApiOperation(value = "注册", notes = "注册")
    @Transactional
    public SimpleResultHelp<User> registUser(@RequestBody User user) {
        Map<String, Object> maps = new HashMap<>();
        SimpleResultHelp simpleResultHelp = new SimpleResultHelp(null);
        if (CommonUtil.notNull(user.getLoginName()) && (null == user.getId())) {
            QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
            userQueryWrapper.eq("login_name", user.getLoginName());
            List<User> users = userService.list(userQueryWrapper);
            if (users.size() > 0) {
                return SimpleResultHelp.result("9999", "登录名存在，请重新填写");
            }
        }
        user.setCreateTime(LocalDateTime.now());
        /*删除班级关系*/
        QueryWrapper<UserClasses> userClassesQueryWrapper = new QueryWrapper<>();
        userClassesQueryWrapper.eq("user_id",user.getId());
        userClassesService.remove(userClassesQueryWrapper);
        /*新增班级关系*/
        if(user.getClassesIds().size()>0){
            user.getClassesIds().stream().forEach(it->{
                UserClasses userClasses = new UserClasses();
                userClasses.setUserId(user.getId());
                userClasses.setCreateTime(LocalDateTime.now());
                userClasses.setDelFlag(1);
                userClasses.setClassesId(it);
                userClassesService.save(userClasses);

            });
        }
        userService.saveOrUpdate(user);
        return simpleResultHelp;
    }


    @PostMapping(value = "/add")
    @ApiOperation(value = "新增", notes = "新增")
    @Transactional
    public SimpleResultHelp<User> add(@RequestBody User user) {
        Map<String, Object> maps = new HashMap<>();
        SimpleResultHelp simpleResultHelp = new SimpleResultHelp(null);
        if (CommonUtil.notNull(user.getLoginName()) && (null == user.getId())) {
            QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
            userQueryWrapper.eq("login_name", user.getLoginName());
            List<User> users = userService.list(userQueryWrapper);
            if (users.size() > 0) {
                return SimpleResultHelp.result("9999", "登录名存在，请重新填写");
            }
        }
        user.setCreateTime(LocalDateTime.now());
        /*删除班级关系*/
        QueryWrapper<UserClasses> userClassesQueryWrapper = new QueryWrapper<>();
        userClassesQueryWrapper.eq("user_id",user.getId());
        userClassesService.remove(userClassesQueryWrapper);
        /*新增班级关系*/
        /*新增班级关系*/
        if(user.getClassesIds().size()>0){
            user.getClassesIds().stream().forEach(it->{
                UserClasses userClasses = new UserClasses();
                userClasses.setUserId(user.getId());
                userClasses.setCreateTime(LocalDateTime.now());
                userClasses.setClassesId(it);
                userClassesService.save(userClasses);

            });
        }

        userService.saveOrUpdate(user);
        return simpleResultHelp;
    }

    @PostMapping(value = "/edit")
    @ApiOperation(value = "修改", notes = "修改")
    @Transactional
    public SimpleResultHelp<User> edit(@RequestBody User user) {
        Map<String, Object> maps = new HashMap<>();
        SimpleResultHelp simpleResultHelp = new SimpleResultHelp(null); 
        /*删除班级关系*/
        QueryWrapper<UserClasses> userClassesQueryWrapper = new QueryWrapper<>();
        userClassesQueryWrapper.eq("user_id",user.getId());
        userClassesService.remove(userClassesQueryWrapper);
        /*新增班级关系*/
        if(user.getClassesIds().size()>0){
            user.getClassesIds().stream().forEach(it->{
                UserClasses userClasses = new UserClasses();
                userClasses.setUserId(user.getId());
                userClasses.setCreateTime(LocalDateTime.now());
                userClasses.setDelFlag(1);
                userClasses.setClassesId(it);
                userClassesService.save(userClasses);

            });
        }
        userService.saveOrUpdate(user);
        return new SimpleResultHelp<>(user);
    }


    @PostMapping(value = "/delById/{id}")
    @ApiOperation(value = "根据id删除", notes = "根据id删除")
    public SimpleResultHelp<Boolean> delById(@PathVariable("id") Integer id) {
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("id", id);
        userUpdateWrapper.set("del_flag", 2);
        userService.update(userUpdateWrapper);
        return new SimpleResultHelp(userService.removeById(id));
    }


    @PostMapping(value = "/delByIds")
    @ApiOperation(value = "批量删除", notes = "批量删除")
    public SimpleResultHelp<Boolean> delByIds(@RequestBody Map ids) {
        return new SimpleResultHelp(userService.removeByIds((List<String>) (ids.get("ids"))));
    }


    @GetMapping(value = "/login")
    public SimpleResultHelp<List<User>> login(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("login_name", user.getLoginName());
        queryWrapper.eq("password", user.getPassword());
        if(CommonUtil.notNull(user.getType())){
            queryWrapper.eq("type", user.getType());
        }
        List<User> userList = userService.list(queryWrapper);
        Collections.sort(userList, Comparator.comparing(User::getCreateTime).reversed());
        if (userList.size() == 0) {
            return SimpleResultHelp.result("9999", "用户名或密码错误");
        }
        return SimpleResultHelp.success(userList);
    }
}
