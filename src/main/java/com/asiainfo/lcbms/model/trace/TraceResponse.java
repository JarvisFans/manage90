package com.asiainfo.lcbms.model.trace;

import lombok.Data;

/**
 * @author felix
 */
@Data
public class TraceResponse {
    private String mdn;
    private String nasIp;
    private String userName;
    private String imsi;
    private String sessionId;
    private String framedIp;
    private Integer timeLen;

    private String error;
    private String appInfo;

    public TraceResponse(String error, String appInfo) {
        this.error = error;
        this.appInfo = appInfo;
    }
}
