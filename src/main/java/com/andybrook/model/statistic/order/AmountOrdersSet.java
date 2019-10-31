package com.andybrook.model.statistic.order;

import com.andybrook.util.Arg;

import java.util.LinkedList;
import java.util.List;

public final class AmountOrdersSet {

    private final List<AmountOrderSetItem> items = new LinkedList<>();

    public void addAmountOrderSetItem(AmountOrderSetItem item) {
        Arg.requireNonNull(item, "AmountOrderSetItem must not be null");
        items.add(item);
    }

    public class AmountOrderSetItem {
        private final long orderId;
        private final double amount;

        public AmountOrderSetItem(long orderId, double amount) {
            this.orderId = orderId;
            this.amount = amount;
        }
    }
}
