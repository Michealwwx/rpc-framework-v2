package com.reign.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName Order
 * @Description 订单
 * @Author wuwenxiang
 * @Date 2019-09-20 22:58
 * @Version 1.0
 **/
public class Order implements Serializable {

    private String orderNo;

    private BigDecimal amount;

    public Order(String orderNo, BigDecimal amount) {
        this.orderNo = orderNo;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNo='" + orderNo + '\'' +
                ", amount=" + amount +
                '}';
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
