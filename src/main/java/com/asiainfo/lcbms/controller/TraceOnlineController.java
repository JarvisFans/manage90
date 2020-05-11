package com.asiainfo.lcbms.controller;

import com.alibaba.fastjson.JSONObject;
import com.asiainfo.lcbms.client.OnlineClient;
import com.asiainfo.lcbms.http.request.TraceRequest;
import com.asiainfo.lcbms.model.TOnline;
import com.asiainfo.lcbms.model.TableResult;
import com.asiainfo.lcbms.service.impl.TraceOnlineBOImpl;
import com.asiainfo.lcbms.service.interfaces.TraceOnlineBO;
import com.asiainfo.lcbms.util.JsonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author felix
 */

@RestController
public class TraceOnlineController {
    @Autowired
    OnlineClient onlineClient;
    private static final TraceOnlineBO traceOnlineBO = new TraceOnlineBOImpl();

    @PostMapping("/traceonline")
    public TableResult traceController(String mdn) throws JsonProcessingException {
        List<TOnline> onlineList = traceOnlineBO.getOnlineListByMdn(mdn);
        TableResult result = new TableResult(0,"执行成功");
        result.setResult(onlineList);
        TraceRequest request = new TraceRequest();
        request.setMdn("861064758110002");
        request.setSid(String.valueOf(System.currentTimeMillis()));
        System.out.println(JsonUtils.objToJson(request));
        JSONObject param = new JSONObject();
        param.put("Mdn", "861064758110002");
        param.put("sid", System.currentTimeMillis());
        String i = onlineClient.test(JsonUtils.objToJson(request));
        System.out.println(i);
        return result;
    }
}
