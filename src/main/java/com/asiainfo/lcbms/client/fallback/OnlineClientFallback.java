package com.asiainfo.lcbms.client.fallback;

import com.asiainfo.lcbms.client.OnlineClient;
import com.asiainfo.lcbms.model.trace.TraceResponse;
import com.google.gson.Gson;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author felix
 */

@Component
@Slf4j
public class OnlineClientFallback implements FallbackFactory<OnlineClient> {
    @Override
    public OnlineClient create(Throwable throwable) {
        return req -> {
            log.warn("Feign Fallback Exception" + throwable);
            TraceResponse response = new TraceResponse("-1","程序降级处理,降级原因:"+throwable);
            return new Gson().toJson(response);
        };
    }
}
