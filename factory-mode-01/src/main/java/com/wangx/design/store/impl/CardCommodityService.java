package com.wangx.design.store.impl;

import com.wangx.design.card.IQiYiCardService;
import com.wangx.design.store.ICommodity;

import java.util.Map;

public class CardCommodityService implements ICommodity {

    // 模拟注入
    private IQiYiCardService iQiYiCardService = new IQiYiCardService();

    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        String mobile = queryUserMobile(uId);
        iQiYiCardService.grantToken(mobile, bizId);
    }

    private String queryUserMobile(String uId) {
        return "15200101232";
    }
}
