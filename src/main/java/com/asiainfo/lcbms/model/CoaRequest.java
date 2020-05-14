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

    private String sessionid;
    private String mdn;
    private String nasip;
    private String apn;

    public CoaRequest() {}

    public CoaRequest(String mdn, String nasip, String apn) {
        this.mdn = mdn;
        this.nasip = nasip;
        this.apn = apn;
        this.sessionid = UUID.randomUUID().toString().replaceAll("-", "");
    }
}
