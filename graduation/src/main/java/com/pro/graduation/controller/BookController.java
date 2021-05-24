package com.pro.graduation.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pro.graduation.entity.Book;
import com.pro.graduation.entity.User;
import com.pro.graduation.service.IBookService;
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

/**
 * <p>
 * 书籍信息 前端控制器
 * </p>
 *
 * @author hwj
 * @since 2021-05-09
 */
@RestController
@RequestMapping("/book")
@Api(value = "BookController",tags = "书籍信息接口")
public class BookController {

@Autowired
IBookService bookService;
    @Autowired
    IUserService userService;
@GetMapping(value = "/getPageList")
@ApiOperation(value = "分页列表", notes = "分页列表")
public ResultHelp getPageList(RequestHelp requestHelp) {
   Page<Book> page = new Page(requestHelp.getPage(), requestHelp.getPageSize());
   Map params = requestHelp.apply();
   QueryWrapper<Book> query = new QueryWrapper<Book>();
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
      if(CommonUtil.notNull(params.get("status"))){
      query.eq("status",params.get("status"));
      }
      if(CommonUtil.notNull(params.get("name"))){
      query.eq("name",params.get("name"));
      }
      if(CommonUtil.notNull(params.get("remark"))){
      query.eq("remark",params.get("remark"));
      }
   page = bookService.page(page,query);
    page.getRecords().stream().forEach(it -> {
        User user = userService.getById(it.getUserId());
        it.setUser(user);
    });
   return CommonUtil.getResultHelp(page);

   }


@GetMapping(value = "/getAllList")
@ApiOperation(value = "全部列表", notes = "全部列表")
public ResultHelp getALLList(RequestHelp requestHelp) {
     Map params = requestHelp.apply();
     QueryWrapper<Book> query = new QueryWrapper<Book>();

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
        if(CommonUtil.notNull(params.get("status"))){
        query.eq("status",params.get("status"));
        }
        if(CommonUtil.notNull(params.get("name"))){
        query.eq("name",params.get("name"));
        }
        if(CommonUtil.notNull(params.get("remark"))){
        query.eq("remark",params.get("remark"));
        }
     List<Book> list = bookService.list(query);
    list.stream().forEach(it -> {
        User user = userService.getById(it.getUserId());
        it.setUser(user);
    });
      return new ResultHelp(list);
 }



@PostMapping(value = "/add")
@ApiOperation(value = "新增", notes = "新增")
public SimpleResultHelp<Book> add(@RequestBody Book book) {
    Map< String, Object> maps = new HashMap<>();
    SimpleResultHelp simpleResultHelp = new SimpleResultHelp(null);
    book.setCreateTime(LocalDateTime.now());
    bookService.saveOrUpdate(book);
    return simpleResultHelp;
    }


    @PostMapping(value = "/edit")
    @ApiOperation(value = "修改", notes = "修改")
    public SimpleResultHelp<Book> edit(@RequestBody Book book) {
        Map< String, Object> maps = new HashMap<>();
        SimpleResultHelp simpleResultHelp = new SimpleResultHelp(null);
    bookService.saveOrUpdate(book);
        return simpleResultHelp;
        }


   @PostMapping(value = "/delById/{id}")
   @ApiOperation(value = "根据id删除", notes = "根据id删除")
   public SimpleResultHelp<Boolean> delById(@PathVariable("id") Integer id) {

    UpdateWrapper<Book> wrapper = new UpdateWrapper<>();
        wrapper.set("del_flag",2);
        wrapper.eq("id",id);
        return new SimpleResultHelp(bookService.update(wrapper));
    }


    @PostMapping(value = "/delByIds")
    @ApiOperation(value = "批量删除", notes = "批量删除")
    public SimpleResultHelp<Boolean> delByIds(@RequestBody Map ids) {
        return new SimpleResultHelp(bookService.removeByIds((List<String>) (ids.get("ids"))));
            }

        }
