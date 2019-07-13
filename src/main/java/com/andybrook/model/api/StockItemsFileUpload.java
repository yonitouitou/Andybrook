package com.andybrook.model.api;

import com.andybrook.model.stock.ProductItem;

import java.time.LocalDateTime;
import java.util.List;

public final class StockItemsFileUpload {

    private String id;
    private int rowsInFile;
    private int rowsProcessed;
    private List<ProductItem> productItems;
    private LocalDateTime uploadDateTime;

    public StockItemsFileUpload(String id, int rowsInFile, int rowsProcessed, List<ProductItem> productItems, LocalDateTime uploadDateTime) {
        this.id = id;
        this.rowsInFile = rowsInFile;
        this.rowsProcessed = rowsProcessed;
        this.productItems = productItems;
        this.uploadDateTime = uploadDateTime;
    }

    public int getRowsInFile() {
        return rowsInFile;
    }

    public int getRowsProcessed() {
        return rowsProcessed;
    }

    public List<ProductItem> getProductItems() {
        return productItems;
    }

    public LocalDateTime getUploadDateTime() {
        return uploadDateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setRowsInFile(int rowsInFile) {
        this.rowsInFile = rowsInFile;
    }

    public void setRowsProcessed(int rowsProcessed) {
        this.rowsProcessed = rowsProcessed;
    }

    public void setProductItems(List<ProductItem> productItems) {
        this.productItems = productItems;
    }

    public void setUploadDateTime(LocalDateTime uploadDateTime) {
        this.uploadDateTime = uploadDateTime;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StockItemsFileUpload{");
        sb.append("rowsInFile=").append(rowsInFile);
        sb.append(", rowsProcessed=").append(rowsProcessed);
        sb.append(", productItems=").append(productItems);
        sb.append(", uploadDateTime=").append(uploadDateTime);
        sb.append('}');
        return sb.toString();
    }
}
