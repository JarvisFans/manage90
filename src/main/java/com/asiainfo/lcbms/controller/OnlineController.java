package com.asiainfo.lcbms.controller;

import com.asiainfo.lcbms.client.CoaClient;
import com.asiainfo.lcbms.model.CoaRequest;
import com.asiainfo.lcbms.model.CoaResponse;
import com.asiainfo.lcbms.util.StringUtil;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhangjp
 * @date 2020-05-11 16:16
 *
 * @description
 */

@RestController
@RequestMapping("/online")
public class OnlineController {

    private static final Logger logger = LoggerFactory.getLogger(OnlineController.class);

    @Autowired
    private CoaClient coaClient;

    @PostMapping("/kickoff")
    public String kickOff(@RequestParam("mdn") String mdn, @RequestParam("nasIp") String nasIp,
                          @RequestParam("apn") String apn) {
        Gson gson = new Gson();
        if (StringUtil.isEmpty(mdn) || StringUtil.isEmpty(nasIp) || StringUtil.isEmpty(apn)) {
            return gson.toJson(new CoaResponse("-1", "mdn,nasip,framedip不能为空"));
        }
        CoaRequest coaRequest = new CoaRequest(mdn, nasIp, apn);
        String response = coaClient.kickOff(gson.toJson(coaRequest));
        return response;
    }
}
