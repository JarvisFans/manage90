package com.asiainfo.lcbms.util;

/**
 * @author zhangjp
 * @date 2020-05-14 17:16
 *
 */
public class StringUtil {

    public static boolean isEmpty(String str) {
        if (str == null || str.trim().length() <= 0) {
            return true;
        }
        return false;
    }
}
