package com.asiainfo.lcbms.model;

import lombok.Data;

/**
 * @author zhangjp
 * @date 2020-05-09 16:35
 *
 */
@Data
public class CoaResponse {
    private String code;
    private String message;

    public CoaResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
