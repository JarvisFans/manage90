package com.asiainfo.lcbms.model.trace;

import com.asiainfo.lcbms.model.TOnline;
import lombok.Data;

import java.util.List;

/**
 * @author felix
 */
@Data
public class TraceResponse {
    private String sid;
    private List<TOnline> onlineList;
    private String appType;
    private String code;
    private String message;
}
