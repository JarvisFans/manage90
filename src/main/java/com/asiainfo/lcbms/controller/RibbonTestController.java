package com.asiainfo.lcbms.controller;

import com.asiainfo.lcbms.client.OnlineService;
import com.asiainfo.lcbms.model.trace.TraceRequest;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author felix
 */

@RestController
@Slf4j
public class RibbonTestController {
    private OnlineService onlineService;

    @Autowired
    public void setOnlineService(OnlineService onlineService) {
        this.onlineService = onlineService;
    }

    @PostMapping("/test/ribbon")
    public String TestRibbon(String mdn, String apn) {
        TraceRequest request = new TraceRequest(mdn, apn);
        Gson gson = new Gson();
        String requestJson = gson.toJson(request);
        log.info(requestJson);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            String responseJson = onlineService.getOnlineList(requestJson);
            log.info(responseJson);
        }
        long endTime = System.currentTimeMillis();
        log.info("程序执行时间:" + (endTime - startTime) + "ms");
        return gson.toJson("程序执行时间:" + (endTime - startTime) + "ms");
    }
}
