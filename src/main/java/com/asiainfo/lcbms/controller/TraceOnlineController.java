package com.asiainfo.lcbms.controller;

import com.asiainfo.lcbms.model.TOnline;
import com.asiainfo.lcbms.model.TableResult;
import com.asiainfo.lcbms.service.impl.TraceOnlineBOImpl;
import com.asiainfo.lcbms.service.interfaces.TraceOnlineBO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author felix
 */

@RestController
public class TraceOnlineController {
    private static final TraceOnlineBO traceOnlineBO = new TraceOnlineBOImpl();

    @PostMapping("/traceonline")
    public TableResult traceController(String mdn) throws JsonProcessingException {
        List<TOnline> onlineList = traceOnlineBO.getOnlineListByMdn(mdn);
        TableResult result = new TableResult(0,"执行成功");
        result.setResult(onlineList);
        return result;
    }
}
