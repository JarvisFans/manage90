package com.asiainfo.lcbms.client.fallback;

import com.asiainfo.lcbms.client.CoaClient;
import com.asiainfo.lcbms.model.CoaResponse;
import com.google.gson.Gson;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author felix
 */

@Component
@Slf4j
public class CoaClientFallback implements FallbackFactory<CoaClient> {

    @Override
    public CoaClient create(Throwable throwable) {
        return req -> {
            log.warn("Feign Fallback Exception" + throwable);
            CoaResponse response = new CoaResponse("-1","程序降级处理,降级原因:"+throwable);
            return new Gson().toJson(response);
        };
    }
}
