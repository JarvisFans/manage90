package com.asiainfo.lcbms.controller;

import com.asiainfo.lcbms.client.OnlineClient;
import com.asiainfo.lcbms.model.online.TraceRequest;
import com.asiainfo.lcbms.model.TableResult;
import com.asiainfo.lcbms.util.JsonUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
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
    public TableResult traceController(String mdn) throws IOException {
        List<Object> onlineList;
        TraceRequest request = new TraceRequest(mdn,String.valueOf(System.currentTimeMillis()));

        String requestJson = JsonUtils.objToJson(request);
        log.info(requestJson);

        String responseJson = onlineClient.getOnlineList(requestJson);

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

    @RequestMapping("/trace")
    public String trace() {
        return "traceonline/traceonline";
    }
}
