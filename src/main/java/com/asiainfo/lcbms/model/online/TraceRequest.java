package com.asiainfo.lcbms.model.online;

import lombok.Data;

/**
 * @author felix
 */
@Data
public class TraceRequest {
    private String mdn;
    private String sid;

    public TraceRequest(String mdn, String sid) {
        this.mdn = mdn;
        this.sid = sid;
    }

}
