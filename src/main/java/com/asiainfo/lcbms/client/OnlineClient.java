package com.asiainfo.lcbms.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author felix
 */
@FeignClient(name="onlineserver")
public interface OnlineClient {
    @PostMapping("/online/query")
    String getOnlineList(String json);
}
