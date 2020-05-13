package com.asiainfo.lcbms.controller;

import com.asiainfo.lcbms.client.OnlineClient;
import com.asiainfo.lcbms.model.TOnline;
import com.asiainfo.lcbms.model.trace.TraceRequest;
import com.asiainfo.lcbms.model.TableResult;
import com.asiainfo.lcbms.model.trace.TraceResponse;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public TableResult traceController(String mdn) {
        List<TOnline> onlineList;
        TableResult result = null;
        TraceRequest request = new TraceRequest(mdn,String.valueOf(System.currentTimeMillis()));
        Gson gson = new Gson();
        String requestJson = gson.toJson(request);
        log.info(requestJson);
        String responseJson = onlineClient.getOnlineList(requestJson);
        log.info(responseJson);
        TraceResponse response = gson.fromJson(responseJson,TraceResponse.class);
        if(response.getCode() != null){
            result = new TableResult(0, "执行失败");
        }else {
            if (response.getOnlineList() != null) {
                onlineList = response.getOnlineList();
                result = new TableResult(0, "执行成功");
                result.setResult(onlineList);
            }
        }

        return result;
    }

}
