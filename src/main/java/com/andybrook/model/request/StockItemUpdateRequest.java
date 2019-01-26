package com.andybrook.model.request;

import com.andybrook.api.rest.jackson.StockItemJsonSerializer;
import com.andybrook.model.product.Product;
import com.andybrook.model.StockItem;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class StockItemUpdateRequest {

    private long stockReportId;
    @JsonDeserialize(using = StockItemJsonSerializer.class)
    private StockItem<? extends Product> stockItem;

    public long getStockReportId() {
        return stockReportId;
    }

    public void setStockReportId(long stockReportId) {
        this.stockReportId = stockReportId;
    }

    public StockItem<? extends Product> getStockItem() {
        return stockItem;
    }

    public void setStockItem(StockItem<? extends Product> stockItem) {
        this.stockItem = stockItem;
    }
}
