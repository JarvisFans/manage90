package com.asiainfo.lcbms.service.interfaces;

import com.asiainfo.lcbms.model.TOnline;

import java.util.List;

/**
 * @author felix
 */
public interface TraceOnlineBO {
    List<TOnline> getOnlineListByMdn(String mdn);
}
