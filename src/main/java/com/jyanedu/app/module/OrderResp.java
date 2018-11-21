package com.jyanedu.app.module;

/**
 * Created by liu_kai on 2018/3/1.
 */
public class OrderResp extends BaseResp{
    private String orderId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    private double totalCost;
}
