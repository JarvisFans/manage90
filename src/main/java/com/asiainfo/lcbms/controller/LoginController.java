package com.asiainfo.lcbms.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author felix
 */
@RestController
public class LoginController {
    @PostMapping("/login")
    public String login(String admin, String password) {
        if ("linkage".equals(admin) && "123456".equals(password)) {
            return "success";
        } else {
            return "账号密码错误";
        }
    }
}
