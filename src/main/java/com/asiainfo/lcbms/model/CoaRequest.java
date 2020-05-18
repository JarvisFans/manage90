package com.asiainfo.lcbms.model;

import lombok.Data;

import java.util.UUID;

/**
 * @author zhangjp
 * @date 2020-05-09 16:01
 *
 */

@Data
public class CoaRequest {

    private String sessionId;
    private String mdn;
    private String nasIp;
    private String apn;

    public CoaRequest() {}

    public CoaRequest(String mdn, String nasip, String apn, String sessionId) {
        this.mdn = mdn;
        this.nasIp = nasip;
        this.apn = apn;
        this.sessionId = sessionId;
    }
}
