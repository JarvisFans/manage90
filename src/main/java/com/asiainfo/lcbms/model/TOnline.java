package com.asiainfo.lcbms.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author felix
 */
@Getter
@Setter
@ToString
public class TOnline {
    private String mdn;
    private String nasIp;
    private String userName;
    private String imsi;
    private String sessionId;
    private String framedIp;
    private Integer timeLen;
    private String apn;
}
