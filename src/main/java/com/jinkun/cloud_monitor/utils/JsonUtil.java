package com.jinkun.cloud_monitor.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.util.Map;

/***
 * @ClassName: JsonUtil
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/11/15 17:42
 * @version : V1.0
 */
public class JsonUtil{

    public static String toJSONString(Object obj){

        return JSON.toJSONString(obj, SerializerFeature.WriteMapNullValue);
    }

    public static Map JSONToMap(String JSON,Class clazz){

        return null;
    }

    public static Object toObject(String json, Class clz) {

        return  JSON.toJavaObject(JSON.parseObject(json), clz);
    }

    public static <T> T toBean(String json, Class<T> clz) {

        return JSON.parseObject(json, clz);
    }

}
