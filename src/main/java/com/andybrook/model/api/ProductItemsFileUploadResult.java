package com.andybrook.model.api;

import com.andybrook.model.stock.ProductItem;

import java.time.LocalDateTime;
import java.util.List;

public final class ProductItemsFileUploadResult {

    private final int rowsInFile;
    private final int rowsProcessed;
    private final List<ProductItem> productItems;
    private final LocalDateTime uploadDateTime;

    public ProductItemsFileUploadResult(int rowsInFile, int rowsProcessed, List<ProductItem> productItems) {
        this.rowsInFile = rowsInFile;
        this.productItems = productItems;
        this.rowsProcessed = rowsProcessed;
        this.uploadDateTime = LocalDateTime.now();
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProductItemsFileUploadResult{");
        sb.append("rowsInFile=").append(rowsInFile);
        sb.append(", rowsProcessed=").append(rowsProcessed);
        sb.append(", productItems=").append(productItems);
        sb.append(", uploadDateTime=").append(uploadDateTime);
        sb.append('}');
        return sb.toString();
    }
}
