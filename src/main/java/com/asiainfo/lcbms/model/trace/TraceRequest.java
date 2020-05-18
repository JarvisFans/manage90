package com.asiainfo.lcbms.model.trace;

import lombok.Data;

/**
 * @author felix
 */
@Data
public class TraceRequest {
    private String mdn;
    private String apn;

    public TraceRequest(String mdn, String apn) {
        this.mdn = mdn;
        this.apn = apn;
    }

}
