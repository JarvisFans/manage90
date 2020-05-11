package com.asiainfo.lcbms.client;

import com.alibaba.fastjson.JSON;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author felix
 */
@FeignClient(name="onlineserver-java")
public interface OnlineClient {
    @PostMapping("/online/query")
    String test(String json);
}
