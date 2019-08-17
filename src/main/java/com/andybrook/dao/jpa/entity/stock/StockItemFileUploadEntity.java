package com.andybrook.dao.jpa.entity.stock;

import java.time.LocalDateTime;
import java.util.List;

public class StockItemFileUploadEntity {

    private final String id;
    private final int rowsInFile;
    private final int rowsProcessed;
    private final List<ProductItemEntity> products;
    private final long uploadTimestamp;

    public StockItemFileUploadEntity(String id, int rowsInFile, int rowsProcessed, List<ProductItemEntity> products, long uploadTimestamp) {
        this.id = id;
        this.rowsInFile = rowsInFile;
        this.rowsProcessed = rowsProcessed;
        this.products = products;
        this.uploadTimestamp = uploadTimestamp;
    }

    public List<ProductItemEntity> getProducts() {
        return products;
    }

    public long getUploadTimestamp() {
        return uploadTimestamp;
    }

    public String getId() {
        return id;
    }

    public int getRowsInFile() {
        return rowsInFile;
    }

    public int getRowsProcessed() {
        return rowsProcessed;
    }
}
