package com.pro.graduation.utils;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/4 0004.
 */
@Data
public class RequestHelp implements Serializable {

    String sortField = "";
    String sortBy = "";
    //查询条件
    String search = "{}";
    //页数
    Integer page = 1;
    //每页跳数
    Integer pageSize = 20;

    Map<String, String> keyMap;

    public  Map<String, String> apply() {
        keyMap = new HashMap<>();
        if (CommonUtil.notNull(search)) {
            keyMap = JSON.parseObject(search, Map.class);
        }
        return keyMap;
    }

}
