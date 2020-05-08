package com.asiainfo.lcbms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author felix
 */
@Controller
public class BaseController {
    @RequestMapping("/")
    public String index() {
        return "traceonline/traceonline";
    }
}
