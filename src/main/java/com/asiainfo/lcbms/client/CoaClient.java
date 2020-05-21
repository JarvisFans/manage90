package com.asiainfo.lcbms.client;

import com.asiainfo.lcbms.client.fallback.CoaClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author zhangjp
 * @date 2020-05-11 19:05
 * @description
 */

@FeignClient(name = "coa-server", fallback = CoaClientFallback.class)
@Primary
public interface CoaClient {

    @PostMapping("/coaserver/aitest/1.0/online/delete")
    String kickOff(String req);
}
