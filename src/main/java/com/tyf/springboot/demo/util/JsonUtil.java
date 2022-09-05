package com.tyf.springboot.demo.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.ObjectUtils;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author TanYuFei
 * FastJson config please see /src/config/FastJsonConfiguration
 * FastJson tools
 */
public class JsonUtil {


    /**
     * a object change to JsonObject.
     * @param obj
     * @return
     */
    public static JSONObject toJsonObject(Object obj){
        if(ObjectUtils.isEmpty(obj))
            return new JSONObject();
        if(obj instanceof String)
            return JSONObject.parseObject(obj.toString());
        else
            return JSONObject.parseObject(JSONObject.toJSONString(obj));
    }

    /**
     * a object change to JsonArray.
     * @param obj
     * @return
     */
    public static JSONArray toJsonArray(Object obj){
        if(ObjectUtils.isEmpty(obj))
            return new JSONArray();
        if(obj instanceof String)
            return JSONObject.parseArray(obj.toString());
        else
            return JSONObject.parseArray(JSONObject.toJSONString(obj));
    }

    public static JSONObject emptyObject(){
        return new JSONObject();
    }

    public static JSONArray emptyArray(){
        return new JSONArray();
    }

    public static Map<String,Object> toMap(JSONObject json){
        Map<String,Object> map = new HashMap<>();
        json.forEach((k,v)->{
            map.put(k,v);
        });
        return map;
    }

    /**
     * sort
     * @param array
     * @param key
     * @param order
     * @return
     */
    public static void sort(JSONArray array,String key,int order){
        array.sort(new Comparator() {
            @Override
            public int compare(Object o, Object t1) {
                JSONObject j1 = toJsonObject(o);
                JSONObject j2 = toJsonObject(t1);
                Object obj1 = j1.get(key);
                return 0;
            }
        });
    }


    public static <T> T getValue(JSONObject json,String key){
        return (T) getValue(json,key,"-");
    }

    public static <T> T getValue(JSONObject json,String key,T defaultValue){
        Object obj = json.get(key);
        return ObjectUtils.isEmpty(obj)?defaultValue:(T) obj;
    }

    public static void main(String[] args) {
        JSONObject json = JsonUtil.emptyObject();
        Object obj = JsonUtil.getValue(json,"H");
        System.out.println(obj);
    }

}
