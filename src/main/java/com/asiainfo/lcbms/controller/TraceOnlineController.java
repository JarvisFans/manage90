package com.asiainfo.lcbms.controller;

import com.asiainfo.lcbms.client.OnlineClient;
import com.asiainfo.lcbms.http.request.TraceRequest;
import com.asiainfo.lcbms.model.TableResult;
import com.asiainfo.lcbms.service.impl.TraceOnlineBOImpl;
import com.asiainfo.lcbms.service.interfaces.TraceOnlineBO;
import com.asiainfo.lcbms.util.JsonUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * @author felix
 */

@RestController
public class TraceOnlineController {
    @Autowired
    private OnlineClient onlineClient;
    private static final TraceOnlineBO traceOnlineBO = new TraceOnlineBOImpl();

    @PostMapping("/traceonline")
    public TableResult traceController(String mdn) throws IOException {
        List<Object> onlineList = null;
        TraceRequest request = new TraceRequest();
        request.setMdn(mdn);
        request.setSid(String.valueOf(System.currentTimeMillis()));
        String requestJson = JsonUtils.objToJson(request);
        String responseJson = onlineClient.test(requestJson);
        System.out.println(requestJson);
//          onlineList = traceOnlineBO.getOnlineListByMdn(mdn);
//              onlineList = JsonUtils.jsonToObjList(TOnline.class,responseJson);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(responseJson);
        if(node.findValue("code") != null ){
            System.out.println(node.findValue("code").toString());
            return null;
        }
        JsonNode value = node.findValue("onlineList");
        onlineList = mapper.readValue(value.toString(), new TypeReference<List<Object>>() {
        });
        TableResult result = new TableResult(0, "执行成功");
        System.out.println(onlineList.toString());
        result.setResult(onlineList);
        return result;
    }
}
