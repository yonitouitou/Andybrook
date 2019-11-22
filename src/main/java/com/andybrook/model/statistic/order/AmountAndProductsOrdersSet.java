package com.andybrook.model.statistic.order;

import com.andybrook.util.Arg;

import java.util.LinkedList;
import java.util.List;

public final class AmountAndProductsOrdersSet {

    private final List<AmountOrderSetItem> items = new LinkedList<>();

    public void addAmountOrderSetItem(AmountOrderSetItem item) {
        Arg.requireNonNull(item, "AmountOrderSetItem must not be null");
        items.add(item);
    }

    public List<AmountOrderSetItem> getItems() {
        return items;
    }

    public static class AmountOrderSetItem {
        private final long orderId;
        private final String orderName;
        private final double amount;

        public AmountOrderSetItem(long orderId, String orderName, double amount) {
            this.orderId = orderId;
            this.orderName = orderName;
            this.amount = amount;
        }

        public long getOrderId() {
            return orderId;
        }

        public String getOrderName() {
            return orderName;
        }

        public double getAmount() {
            return amount;
        }
    }

    @Override
    public String toString() {
        return "AmountOrdersSet{" +
                "items=" + items +
                '}';
    }
}
