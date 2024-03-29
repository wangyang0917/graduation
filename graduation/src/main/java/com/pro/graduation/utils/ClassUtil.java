package com.pro.graduation.utils;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/12 0012.
 */
public class ClassUtil {

    /**
     * 将一个类查询方式加入map（属性值为int型时，0时不加入，
     * 属性值为String型或Long时为null和“”不加入）
     *
     */
    public static Map<String, Object> setConditionMap(Object obj){
        Map<String, Object> map = new HashMap<String, Object>();
        if(obj==null){
            return null;
        }
        Field[] fields = obj.getClass().getDeclaredFields();
        for(Field field : fields){
            String fieldName =  field.getName();
            if(getValueByFieldName(fieldName,obj)!=null)
                map.put(fieldName,  getValueByFieldName(fieldName,obj));
        }

        return map;

    }
    /**
     * 根据属性名获取该类此属性的值
     * @param fieldName
     * @param object
     * @return
     */
    private static Object getValueByFieldName(String fieldName,Object object){
        String firstLetter=fieldName.substring(0,1).toUpperCase();
        String getter = "get"+firstLetter+fieldName.substring(1);
        try {
            Method method = object.getClass().getMethod(getter);
            Object value = method.invoke(object);
            return value;
        } catch (Exception e) {
            return null;
        }

    }
     public  static Map<String, String> objectToMap(Object obj){
        Map<String, String> keyMap  = new HashMap<>();
        if (CommonUtil.notNull(obj)) {
            keyMap = JSON.parseObject(JSON.toJSONString(obj), Map.class);
        }
        return keyMap;
    }


}
