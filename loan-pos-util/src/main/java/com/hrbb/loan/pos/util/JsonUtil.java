package com.hrbb.loan.pos.util;

import java.io.IOException;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author zhangwei5@hrbb.com.cn
 * @date 2015年9月24日上午10:33:30 
 */
public class JsonUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtil.class);
    private static ObjectMapper mapper;
    static {
        mapper = new ObjectMapper();
    }

    /**
     * @param object tojson 的对象
     * @return json str
     */
    public static String toJson(Object object) {
        String res = null;
        if(null != object)
            try {
                res = mapper.writeValueAsString(object);
            } catch (IOException e) {
                LOGGER.error("object to json 异常："+ExceptionUtils.getStackTrace(e));
            }
        return res;
    }
    
    /**
     * @param json json字符串
     * @param clazz json字符串反序列化后的对象
     * @return
     */
    public static <T>T toObject(String json,Class<T>clazz){
        T t = null;
        if(null != json){
            try {
                t = mapper.readValue(json, clazz);
            } catch (IOException e) {
                LOGGER.error("json to object 异常："+ExceptionUtils.getStackTrace(e));
                e.printStackTrace();
            }
        }
        return t;
    }

}
