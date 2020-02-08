package com.andybrook.model.api;

public class AggregatedOrderInfo {

    private final int orderItemSize;
    private final int productSize;
    private final double totalPrice;

    public AggregatedOrderInfo(int orderItemSize, int productSize, double totalPrice) {
        this.orderItemSize = orderItemSize;
        this.productSize = productSize;
        this.totalPrice = totalPrice;
    }

    public int getOrderItemSize() {
        return orderItemSize;
    }

    public int getProductSize() {
        return productSize;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "AggregatedOrderInfo{" +
                "orderItemSize=" + orderItemSize +
                ", productSize=" + productSize +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
