package com.wangx.design.store.impl;

import cn.hutool.json.JSONUtil;
import cn.hutool.log.Log;
import com.wangx.design.coupon.CouponResult;
import com.wangx.design.coupon.CouponService;
import com.wangx.design.store.ICommodity;

import java.util.Map;

public class CouponCommodityService implements ICommodity {

    /**
     * 摹拟注入
     */
    private CouponService couponService = new CouponService();

    private static final Log logger = Log.get(CouponCommodityService.class);

    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        CouponResult couponResult = couponService.sendCoupon(uId, commodityId, bizId);
        logger.info("请求参数[优惠券] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, JSONUtil.toJsonStr(extMap));
        logger.info("测试结果[优惠券]：{}", JSONUtil.toJsonStr(couponResult));
        if (!"0000".equals(couponResult.getCode())) throw new RuntimeException(couponResult.getMsg());
    }
}
