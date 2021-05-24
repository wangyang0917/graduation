package com.pro.graduation.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonUtil {
    final static Logger logger = LoggerFactory.getLogger(CommonUtil.class);

    public static boolean notNull(Object object) {
        boolean flag = true;
        if (null == object || object.equals("")||object.equals(0)) {
            flag = false;
        }
        return flag;
    }

    public static ResultHelp getResultHelp(IPage page) {
        ResultHelp resultHelp = new ResultHelp();
        resultHelp.setResultList(page.getRecords());
        resultHelp.setPageCount((int) page.getPages());
        resultHelp.setPage((int) page.getCurrent());
        resultHelp.setPageSize((int) page.getSize());
        resultHelp.setResultCount((int) page.getTotal());
        return resultHelp;
    }


}
