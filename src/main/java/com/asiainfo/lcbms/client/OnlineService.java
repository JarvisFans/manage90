package com.asiainfo.lcbms.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

/**
 * @author felix
 * @Description 使用RestTemplate实现的测试用查在线服务
 */
@Component
public class OnlineService {

    private RestTemplate restTemp;

    @Autowired
    public void setRestTemp(RestTemplate restTemp) {
        this.restTemp = restTemp;
    }

    public String getOnlineList(String json){
        String url = "http://onlineserver/onlineserver/aitest/1.0/online/query";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> requestEntity = new HttpEntity<>(json, headers);
        ResponseEntity<String> responseEntity = restTemp.exchange(url, HttpMethod.GET, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }
}
