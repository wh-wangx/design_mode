package com.wangx.design.store.impl;

import cn.hutool.json.JSONUtil;
import cn.hutool.log.Log;
import com.wangx.design.goods.DeliverReq;
import com.wangx.design.goods.GoodsService;
import com.wangx.design.store.ICommodity;

import java.util.Map;

public class GoodsCommodityService implements ICommodity {

    /**
     * 模拟注入
     */
    private GoodsService goodsService = new GoodsService();

    private static final Log logger = Log.get(GoodsCommodityService.class);

    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        DeliverReq deliverReq = new DeliverReq();
        deliverReq.setUserName(this.queryUserName(uId));
        deliverReq.setUserPhone(this.queryUserPhoneNumber(uId));
        deliverReq.setSku(commodityId);
        deliverReq.setOrderId(bizId);
        deliverReq.setConsigneeUserName(extMap.get("consigneeUserName"));
        deliverReq.setConsigneeUserPhone(extMap.get("consigneeUserPhone"));
        deliverReq.setConsigneeUserAddress(extMap.get("consigneeUserAddress"));

        Boolean isSuccess = goodsService.deliverGoods(deliverReq);

        logger.info("请求参数[优惠券] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, JSONUtil.toJsonStr(   extMap));
        logger.info("测试结果[优惠券]：{}", isSuccess);

        if (!isSuccess)
            throw new RuntimeException("实物商品发放失败");
    }

    private String queryUserName(String uId) {
        return "花花";
    }

    private String queryUserPhoneNumber(String uId) {
        return "15200101232";
    }
}
