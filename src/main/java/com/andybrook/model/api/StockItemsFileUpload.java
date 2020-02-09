package com.andybrook.model.api;

import com.andybrook.model.BarCode;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;

@Document(indexName = "stock_items_file_upload")
public final class StockItemsFileUpload {

    @Id
    private String id;
    private int rowsInFile;
    private int rowsProcessed;
    private List<ProductToUpload> productsForUpload;
    private long uploadTimestamp;

    private StockItemsFileUpload() {}

    public StockItemsFileUpload(String id, int rowsInFile, int rowsProcessed, List<ProductToUpload> productsForUpload, long uploadTimestamp) {
        this.id = id;
        this.rowsInFile = rowsInFile;
        this.rowsProcessed = rowsProcessed;
        this.productsForUpload = productsForUpload;
        this.uploadTimestamp = uploadTimestamp;
    }

    public int getRowsInFile() {
        return rowsInFile;
    }

    public int getRowsProcessed() {
        return rowsProcessed;
    }

    public List<ProductToUpload> getProductsForUpload() {
        return productsForUpload;
    }

    public long getUploadTimestamp() {
        return uploadTimestamp;
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

    public void setProductsForUpload(List<ProductToUpload> productsForUpload) {
        this.productsForUpload = productsForUpload;
    }

    public void setUploadTimestamp(long uploadTimestamp) {
        this.uploadTimestamp = uploadTimestamp;
    }

    public static class ProductToUpload {

        private final String name;
        private final double price;
        private final BarCode barCode;

        public ProductToUpload(String name, double price, BarCode barCode) {
            this.name = name;
            this.price = price;
            this.barCode = barCode;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public BarCode getBarCode() {
            return barCode;
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StockItemsFileUpload{");
        sb.append("rowsInFile=").append(rowsInFile);
        sb.append(", rowsProcessed=").append(rowsProcessed);
        sb.append(", productItems=").append(productsForUpload);
        sb.append(", uploadDateTime=").append(uploadTimestamp);
        sb.append('}');
        return sb.toString();
    }
}
