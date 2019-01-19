package com.andybrook.model;

import com.andybrook.enums.ReportStatus;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StockReport {

    protected Long id;
    protected String name;
    protected String comment;
    protected Map<Long, StockItem<? extends Product>> products;
    protected final LocalDateTime createdDateTime;
    protected ReportStatus status;

    public StockReport(Long id, String name, Map<Long, StockItem<? extends Product>> products) {
        this.id = id;
        this.name = name;
        this.products = products;
        this.status = ReportStatus.CREATED;
        this.comment = "";
        this.createdDateTime = LocalDateTime.now();
    }

    public void addItem(StockItem<? extends Product> item) {
        products.put(item.getId(), item);
    }

    public void deleteItem(long stockItemId) {
        products.remove(stockItemId);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setProducts(Map<Long, StockItem<? extends Product>> products) {
        this.products = products;
    }

    public void setStatus(ReportStatus status) {
        this.status = status;
    }

    public Collection<StockItem<? extends Product>> getProducts() {
        return products.values();
    }

    public List<StockItem<? extends Product>> getProductsAsList() {
        return products.values()
                .stream()
                .collect(Collectors.toList());
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public ReportStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StockReport{");
        sb.append("id=").append(id);
        sb.append(", products=").append(products);
        sb.append(", createdDateTime=").append(createdDateTime);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }
}
