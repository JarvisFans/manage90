package com.asiainfo.lcbms.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author zhangjp
 * @date 2020-05-11 19:05
 *
 * @description
 */

@FeignClient("coa-server")
public interface CoaClient {

    @PostMapping("/kickoff")
    String kickOff(String req);
}
