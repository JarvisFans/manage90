package com.asiainfo.lcbms.controller;

import com.asiainfo.lcbms.model.TOnline;
import com.asiainfo.lcbms.service.impl.TraceOnlineBOImpl;
import com.asiainfo.lcbms.service.interfaces.TraceOnlineBO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author felix
 */

@Controller
public class TraceOnlineController {
    private static TraceOnlineBO traceOnlineBO = new TraceOnlineBOImpl();

    @PostMapping("/traceonline")
    @ResponseBody
    public String traceController(@RequestParam(value="mdn",required = false, defaultValue = "1") String mdn) {
        System.out.println(mdn);
        List<TOnline> onlineList = traceOnlineBO.getOnlineListByMdn(mdn);
        return onlineList.toString();
    }
}
