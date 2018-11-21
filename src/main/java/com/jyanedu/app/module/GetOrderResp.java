package com.jyanedu.app.module;

import com.jyanedu.app.beans.Order;

/**
 * Created by liu_kai on 2018/3/1.
 */
public class GetOrderResp extends BaseResp{
    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
