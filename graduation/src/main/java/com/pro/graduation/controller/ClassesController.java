package com.pro.graduation.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pro.graduation.entity.Classes;
import com.pro.graduation.service.IClassesService;
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
 * 班级 前端控制器
 * </p>
 *
 * @author hwj
 * @since 2021-05-09
 */
@RestController
@RequestMapping("/classes")
@Api(value = "ClassesController", tags = "班级接口")
public class ClassesController {

    @Autowired
    IClassesService classesService;

    @GetMapping(value = "/getPageList")
    @ApiOperation(value = "分页列表", notes = "分页列表")
    public ResultHelp getPageList(RequestHelp requestHelp) {
        Page<Classes> page = new Page(requestHelp.getPage(), requestHelp.getPageSize());
        Map params = requestHelp.apply();
        QueryWrapper<Classes> query = new QueryWrapper<Classes>();
        if (CommonUtil.notNull(params.get("id"))) {
            query.eq("id", params.get("id"));
        }
        if (CommonUtil.notNull(params.get("name"))) {
            query.eq("name", params.get("name"));
        }
        if (CommonUtil.notNull(params.get("remark"))) {
            query.eq("remark", params.get("remark"));
        }
        if (CommonUtil.notNull(params.get("Total"))) {
            query.eq("Total", params.get("Total"));
        }
        if (CommonUtil.notNull(params.get("delFlag"))) {
            query.eq("del_flag", params.get("delFlag"));
        }
        if (CommonUtil.notNull(params.get("createTime"))) {
            query.eq("create_time", params.get("createTime"));
        }
        page = classesService.page(page, query);
        return CommonUtil.getResultHelp(page);

    }


    @GetMapping(value = "/getAllList")
    @ApiOperation(value = "全部列表", notes = "全部列表")
    public ResultHelp getALLList(RequestHelp requestHelp) {
        Map params = requestHelp.apply();
        QueryWrapper<Classes> query = new QueryWrapper<Classes>();

        if (CommonUtil.notNull(params.get("id"))) {
            query.eq("id", params.get("id"));
        }
        if (CommonUtil.notNull(params.get("name"))) {
            query.eq("name", params.get("name"));
        }
        if (CommonUtil.notNull(params.get("remark"))) {
            query.eq("remark", params.get("remark"));
        }
        if (CommonUtil.notNull(params.get("Total"))) {
            query.eq("Total", params.get("Total"));
        }
        if (CommonUtil.notNull(params.get("delFlag"))) {
            query.eq("del_flag", params.get("delFlag"));
        }
        if (CommonUtil.notNull(params.get("createTime"))) {
            query.eq("create_time", params.get("createTime"));
        }
        List<Classes> list = classesService.list(query);
        return new ResultHelp(list);
    }


    @PostMapping(value = "/add")
    @ApiOperation(value = "新增", notes = "新增")
    public SimpleResultHelp<Classes> add(@RequestBody Classes classes) {
        Map<String, Object> maps = new HashMap<>();
        SimpleResultHelp simpleResultHelp = new SimpleResultHelp(null);
        classes.setCreateTime(LocalDateTime.now());
        classesService.saveOrUpdate(classes);
        return simpleResultHelp;
    }


    @PostMapping(value = "/edit")
    @ApiOperation(value = "修改", notes = "修改")
    public SimpleResultHelp<Classes> edit(@RequestBody Classes classes) {
        Map<String, Object> maps = new HashMap<>();
        SimpleResultHelp simpleResultHelp = new SimpleResultHelp(null);
        classesService.saveOrUpdate(classes);
        return simpleResultHelp;
    }


    @PostMapping(value = "/delById/{id}")
    @ApiOperation(value = "根据id删除", notes = "根据id删除")
    public SimpleResultHelp<Boolean> delById(@PathVariable("id") Integer id) {

        UpdateWrapper<Classes> wrapper = new UpdateWrapper<>();
        wrapper.set("del_flag", 2);
        wrapper.eq("id", id);
        return new SimpleResultHelp(classesService.update(wrapper));
    }


    @PostMapping(value = "/delByIds")
    @ApiOperation(value = "批量删除", notes = "批量删除")
    public SimpleResultHelp<Boolean> delByIds(@RequestBody Map ids) {
        return new SimpleResultHelp(classesService.removeByIds((List<String>) (ids.get("ids"))));
    }

}
