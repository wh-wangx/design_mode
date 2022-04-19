package com.wangx.design.coupon;

/**
 * 模拟优惠券服务
 */
public class CouponService {

    public CouponResult sendCoupon(String Uid, String couponNumber, String uuid) {
        System.out.println("模拟发放一张优惠券：" + Uid + "," + couponNumber + "," + uuid);
        return new CouponResult("0000", "发放成功");
    }

}
