package com.wangx.design.goods;

import cn.hutool.json.JSONUtil;

/**
 * 模拟实物商品服务
 */
public class GoodsService {

    public Boolean deliverGoods(DeliverReq req) {
        System.out.println("模拟发货实物商品一个：" + JSONUtil.toJsonStr(req));
        return true;
    }
}
