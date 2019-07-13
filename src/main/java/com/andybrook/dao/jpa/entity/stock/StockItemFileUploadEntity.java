package com.andybrook.dao.jpa.entity.stock;

import java.time.LocalDateTime;
import java.util.List;

public class StockItemFileUploadEntity {

    private final String id;
    private final int rowsInFile;
    private final int rowsProcessed;
    private final List<ProductItemEntity> products;
    private final LocalDateTime uploadDateTime;

    public StockItemFileUploadEntity(String id, int rowsInFile, int rowsProcessed, List<ProductItemEntity> products, LocalDateTime uploadDateTime) {
        this.id = id;
        this.rowsInFile = rowsInFile;
        this.rowsProcessed = rowsProcessed;
        this.products = products;
        this.uploadDateTime = uploadDateTime;
    }

    public List<ProductItemEntity> getProducts() {
        return products;
    }

    public LocalDateTime getUploadDateTime() {
        return uploadDateTime;
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
