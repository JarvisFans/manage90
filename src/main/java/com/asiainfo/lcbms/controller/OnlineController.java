package com.asiainfo.lcbms.controller;

import com.asiainfo.lcbms.client.CoaClient;
import com.asiainfo.lcbms.model.CoaRequest;
import com.asiainfo.lcbms.model.CoaResponse;
import com.asiainfo.lcbms.util.StringUtil;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjp
 * @date 2020-05-11 16:16
 * @description
 */

@RestController
@Slf4j
@RequestMapping("/online")
public class OnlineController {

    private CoaClient coaClient;

    @Autowired
    public void setCoaClient(CoaClient coaClient) {
        this.coaClient = coaClient;
    }

    @PostMapping("/kickoff")
    public String kickOff(@RequestParam(value = "mdn") String mdn, @RequestParam(value = "nasIp") String nasIp,
                          @RequestParam(value = "apn") String apn, @RequestParam(value = "sessionId") String sessionId) {
        Gson gson = new Gson();
        try {
            if (StringUtil.isEmpty(mdn) || StringUtil.isEmpty(nasIp) || StringUtil.isEmpty(apn) || StringUtil.isEmpty(sessionId)) {
                return gson.toJson(new CoaResponse("-1", "mdn,nasip,framedip,sessionId不能为空"));
            }
            CoaRequest coaRequest = new CoaRequest(mdn, nasIp, apn, sessionId);
            String requestJson = gson.toJson(coaRequest);
            log.info(requestJson);
            long startTime = System.currentTimeMillis();
            String response = coaClient.kickOff(gson.toJson(coaRequest));
            long endTime = System.currentTimeMillis();
            log.info("程序执行时间:" + (endTime - startTime) + "ms");
            log.info(response);
            return response;
        } catch (Exception e) {
            Map<String, String> map = new HashMap<>();
            map.put("error", "error");
            return gson.toJson(map);
        }
    }
}
