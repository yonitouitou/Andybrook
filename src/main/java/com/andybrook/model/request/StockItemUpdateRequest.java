package com.andybrook.model.request;

import com.andybrook.api.rest.jackson.StockItemJsonSerializer;
import com.andybrook.model.product.Product;
import com.andybrook.model.StockItem;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class StockItemUpdateRequest {

    private long orderId;
    @JsonDeserialize(using = StockItemJsonSerializer.class)
    private StockItem<? extends Product> stockItem;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public StockItem<? extends Product> getStockItem() {
        return stockItem;
    }

    public void setStockItem(StockItem<? extends Product> stockItem) {
        this.stockItem = stockItem;
    }
}
