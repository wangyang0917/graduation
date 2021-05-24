package com.pro.graduation.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pro.graduation.entity.News;
import com.pro.graduation.service.INewsService;
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
 * 新闻 前端控制器
 * </p>
 *
 * @author hwj
 * @since 2021-04-05
 */
@RestController
@RequestMapping("/news")
@Api(value = "NewsController",tags = "新闻接口")
public class NewsController {

@Autowired
INewsService newsService;

@GetMapping(value = "/getPageList")
@ApiOperation(value = "分页列表", notes = "分页列表")
public ResultHelp getPageList(RequestHelp requestHelp) {
   Page<News> page = new Page(requestHelp.getPage(), requestHelp.getPageSize());
   Map params = requestHelp.apply();
   QueryWrapper<News> query = new QueryWrapper<News>();
      if(CommonUtil.notNull(params.get("id"))){
      query.eq("id",params.get("id"));
      }
      if(CommonUtil.notNull(params.get("name"))){
      query.eq("name",params.get("name"));
      }
      if(CommonUtil.notNull(params.get("remark"))){
      query.eq("remark",params.get("remark"));
      }

      if(CommonUtil.notNull(params.get("photo"))){
      query.eq("photo",params.get("photo"));
      }
      if(CommonUtil.notNull(params.get("delFlag"))){
      query.eq("del_flag",params.get("delFlag"));
      }
      if(CommonUtil.notNull(params.get("createTime"))){
      query.eq("create_time",params.get("createTime"));
      }
   page = newsService.page(page,query);
   return CommonUtil.getResultHelp(page);

   }


@GetMapping(value = "/getAllList")
@ApiOperation(value = "全部列表", notes = "全部列表")
public ResultHelp getALLList(RequestHelp requestHelp) {
     Map params = requestHelp.apply();
     QueryWrapper<News> query = new QueryWrapper<News>();

        if(CommonUtil.notNull(params.get("id"))){
        query.eq("id",params.get("id"));
        }
        if(CommonUtil.notNull(params.get("name"))){
        query.eq("name",params.get("name"));
        }
        if(CommonUtil.notNull(params.get("remark"))){
        query.eq("remark",params.get("remark"));
        }
        if(CommonUtil.notNull(params.get("photo"))){
        query.eq("photo",params.get("photo"));
        }

        if(CommonUtil.notNull(params.get("delFlag"))){
        query.eq("del_flag",params.get("delFlag"));
        }
        if(CommonUtil.notNull(params.get("createTime"))){
        query.eq("create_time",params.get("createTime"));
        }
     List<News> list = newsService.list(query);
      return new ResultHelp(list);
 }



@PostMapping(value = "/add")
@ApiOperation(value = "新增", notes = "新增")
public SimpleResultHelp<News> add(@RequestBody News news) {
    Map< String, Object> maps = new HashMap<>();
    SimpleResultHelp simpleResultHelp = new SimpleResultHelp(null);
    news.setCreateTime(LocalDateTime.now());
    newsService.saveOrUpdate(news);
    return simpleResultHelp;
    }


    @PostMapping(value = "/edit")
    @ApiOperation(value = "修改", notes = "修改")
    public SimpleResultHelp<News> edit(@RequestBody News news) {
        Map< String, Object> maps = new HashMap<>();
        SimpleResultHelp simpleResultHelp = new SimpleResultHelp(null);
    newsService.saveOrUpdate(news);
        return simpleResultHelp;
        }


   @PostMapping(value = "/delById/{id}")
   @ApiOperation(value = "根据id删除", notes = "根据id删除")
   public SimpleResultHelp<Boolean> delById(@PathVariable("id") Integer id) {
//
//           UpdateWrapper<News> wrapper = new UpdateWrapper<>();
//        wrapper.set("del_flag",2);
//        wrapper.eq("id",id);
        return new SimpleResultHelp(newsService.removeById(id));
    }


    @PostMapping(value = "/delByIds")
    @ApiOperation(value = "批量删除", notes = "批量删除")
    public SimpleResultHelp<Boolean> delByIds(@RequestBody Map ids) {
        return new SimpleResultHelp(newsService.removeByIds((List<String>) (ids.get("ids"))));
            }

        }
