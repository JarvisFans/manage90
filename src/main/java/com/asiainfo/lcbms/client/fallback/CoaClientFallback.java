package com.asiainfo.lcbms.client.fallback;

import com.asiainfo.lcbms.client.CoaClient;
import com.asiainfo.lcbms.model.CoaResponse;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

/**
 * @author felix
 */

@Component
public class CoaClientFallback implements CoaClient {
    @Override
    public String kickOff(String req) {
        CoaResponse response = new CoaResponse("-1","程序熔断，降级处理");
        return new Gson().toJson(response);
    }
}
