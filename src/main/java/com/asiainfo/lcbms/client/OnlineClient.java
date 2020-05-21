package com.asiainfo.lcbms.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author felix
 */
@FeignClient(name="onlineserver")
public interface OnlineClient {
    @GetMapping("/onlineserver/aitest/1.0/online/query")
    String getOnlineList(String req);
}
