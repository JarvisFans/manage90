package com.asiainfo.lcbms.util;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author felix
 */
public class JsonUtils {
    public static String objToJson(Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }


    public static Object jsonToObj(Object obj,String jsonStr) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        return obj = mapper.readValue(jsonStr, obj.getClass());
    }

    /**
     * 将对象转化为Table展示所需要的json格式
     * {"errorNo":"0","errorInfo":"执行成功","results":{"data":[]}}
     * @param obj
     * @return
     */
    public static String toLayUIJson(Object obj) {
        return null;
    }
}
