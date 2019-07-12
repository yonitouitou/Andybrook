package com.andybrook.dao.jpa.entity.stock;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(indexName = "stock_item_file_upload")
public class StockItemFileUploadEntity {

    @Id
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

    public StockItemFileUploadEntity(int rowsInFile, int rowsProcessed, List<ProductItemEntity> products, LocalDateTime uploadDateTime) {
        this.id = null;
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
