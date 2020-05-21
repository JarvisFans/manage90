package com.asiainfo.lcbms.controller;

import com.asiainfo.lcbms.client.OnlineClient;
import com.asiainfo.lcbms.model.TOnline;
import com.asiainfo.lcbms.model.TableResult;
import com.asiainfo.lcbms.model.trace.TraceRequest;
import com.asiainfo.lcbms.model.trace.TraceResponse;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author felix
 */

@RestController
@Slf4j
public class TraceOnlineController {

    private OnlineClient onlineClient;

    @Autowired
    public void setOnlineClient(OnlineClient onlineClient) {
        this.onlineClient = onlineClient;
    }

    @PostMapping("/traceonline")
    public TableResult traceController(String mdn, String apn) {
        List<TOnline> onlineList;
        TableResult result = null;
        TraceRequest request = new TraceRequest(mdn, apn);
        try {
            Gson gson = new Gson();
            String requestJson = gson.toJson(request);
            log.info(requestJson);
            long startTime = System.currentTimeMillis();
            String responseJson = onlineClient.getOnlineList(requestJson);
            long endTime = System.currentTimeMillis();
            // 总计执行时间
            log.info("程序执行时间:" + (endTime - startTime) + "ms");
            log.info(responseJson);

            if (responseJson.startsWith("{")) {
                TraceResponse response = gson.fromJson(responseJson, TraceResponse.class);
                if (response.getError() != null) {
                    result = new TableResult(0, response.getError());
                    log.info("服务端返回错误信息:" + response.getError());
                }
            } else {
                Type listType = new TypeToken<ArrayList<TOnline>>() {
                }.getType();
                onlineList = gson.fromJson(responseJson, listType);
                if (onlineList.isEmpty()) {
                    result = new TableResult(0, "用户不在线");
                } else {
                    result = new TableResult(0, "执行成功");
                    result.setResult(onlineList);
                    log.info(onlineList.toString());
                }
            }
        } catch (Exception e) {
            log.error("Controller层错误", e);
            result = new TableResult(0, "执行失败");
        }
        return result;
    }
}
