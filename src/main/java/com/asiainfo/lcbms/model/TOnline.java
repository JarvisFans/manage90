package com.asiainfo.lcbms.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

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
    private String  framedip;
    private Integer timelen;
    // private String apn;


    public TOnline() {
    }

    public TOnline(String mdn, String nasip, String username, String imsi, String sessionid, String framedip, Integer timelen) {
        this.mdn = mdn;
        this.nasip = nasip;
        this.username = username;
        this.imsi = imsi;
        this.sessionid = sessionid;
        this.framedip = framedip;
        this.timelen = timelen;
    }
}
