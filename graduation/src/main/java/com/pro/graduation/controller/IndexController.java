package com.pro.graduation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2018/3/20 0020.
 */

@Controller
@RequestMapping("/home")
public class IndexController {
    @RequestMapping("/{page}.html")
    public String sindex(@PathVariable("page") String page) {
        return  page;
    }
}
