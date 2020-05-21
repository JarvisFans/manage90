package com.asiainfo.lcbms.config;

import com.netflix.loadbalancer.*;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * @author felix
 */
@Configuration
public class RibbonConfig {
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(new HttpComponentsClientRestfulHttpRequestFactory());
        return restTemplate;
    }

    @Bean
    public IRule myRule(){
        // 随机
        return new RandomRule();
        // 轮询
        // return new RoundRobinRule();
        // 重试
        // return new RetryRule();
        // 响应时间权重
        // return new WeightedResponseTimeRule();
        // 最空闲连接策略
        // return new BestAvailableRule();
        // return new ZoneAvoidanceRule();
    }

    /**
     * see https://blog.belonk.com/c/http_resttemplate_get_with_body.html
     */
    private static final class HttpComponentsClientRestfulHttpRequestFactory extends HttpComponentsClientHttpRequestFactory {
        @Override
        protected HttpUriRequest createHttpUriRequest(HttpMethod httpMethod, URI uri) {
            if (httpMethod == HttpMethod.GET) {
                return new HttpGetRequestWithEntity(uri);
            }
            return super.createHttpUriRequest(httpMethod, uri);
        }
    }

    private static final class HttpGetRequestWithEntity extends HttpEntityEnclosingRequestBase {
        public HttpGetRequestWithEntity(final URI uri) {
            super.setURI(uri);
        }

        @Override
        public String getMethod() {
            return HttpMethod.GET.name();
        }
    }
}
