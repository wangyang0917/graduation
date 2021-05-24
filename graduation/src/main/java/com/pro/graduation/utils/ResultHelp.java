package com.pro.graduation.utils;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/4/4 0004.
 */
@Data
public class ResultHelp<T, D> implements Serializable {

    String resCode = "0000";
    String resDesc;
    Integer page = 1;

    Integer pageSize = 20;

    Integer pageCount = 0;

    List<T> resultList;

    Integer resultCount = 0;

    D data;

    public ResultHelp() {
    }

    public ResultHelp(D data) {
        this.data = data;
    }
    public ResultHelp(List<T> list) {
        this.resultList = list;
    }
    public ResultHelp(String resCode) {
        this.resCode = resCode;
    }
}
