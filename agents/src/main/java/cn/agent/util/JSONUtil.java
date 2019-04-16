package cn.agent.util;

import com.alibaba.fastjson.JSON;

public class JSONUtil {

    //将制定字符串转换成JSON对象
    public static Object strToJSON(String str){
        return JSON.parseObject( str );
    }

}
