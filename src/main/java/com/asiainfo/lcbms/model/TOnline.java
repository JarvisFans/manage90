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
    private String nasip;
    private String username;
    private String imsi;
    private String sessionid;
    private String framedip;
    private Integer timelen;
    private String apn;
}
