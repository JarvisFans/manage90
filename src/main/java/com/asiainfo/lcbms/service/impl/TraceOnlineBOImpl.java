package com.asiainfo.lcbms.service.impl;

import com.asiainfo.lcbms.model.TOnline;
import com.asiainfo.lcbms.service.interfaces.TraceOnlineBO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author felix
 */
public class TraceOnlineBOImpl implements TraceOnlineBO {
    @Override
    public List<TOnline> getOnlineListByMdn(String mdn) {
        // Test
        TOnline online1 = new TOnline(mdn,"1.1.1.1","user1",
                "imsi1","sessionid1","2.2.2.2",20);
        TOnline online2 = new TOnline("mdn2","3.3.3.3","user2",
                "imsi2","sessionid2","4.4.4.4",20);
        List<TOnline> list = new ArrayList<>();
        //
        mdn = "861064758110002";

        list.add(online1);
        list.add(online2);
        return list;
    }
}
