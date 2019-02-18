package com.andybrook.model;

import com.andybrook.enums.ReportStatus;
import com.andybrook.exception.StockReportClosed;
import com.andybrook.model.customer.Customer;
import com.andybrook.model.customer.Store;
import com.andybrook.model.product.Product;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;

public class StockReport {

    protected Long id;
    protected String name;
    protected String comment;
    protected final Customer customer;
    protected Map<Long, StockItem<? extends Product>> items;
    protected final LocalDateTime createdDateTime;
    protected LocalDateTime closeDateTime;
    protected ReportStatus status;

    public StockReport(Long id, String name, Customer customer, Map<Long, StockItem<? extends Product>> items) {
        this.id = id;
        this.name = name;
        this.customer = customer;
        this.items = items;
        this.status = ReportStatus.OPEN;
        this.comment = "";
        this.createdDateTime = LocalDateTime.now();
    }

    public void addItem(StockItem<? extends Product> item) {
        items.put(item.getId(), item);
    }

    public void deleteItem(long stockItemId) {
        items.remove(stockItemId);
    }

    public void close() throws StockReportClosed {
        if (isClosed()) {
            throw new StockReportClosed(id);
        }
        status = ReportStatus.CLOSED;
        closeDateTime = LocalDateTime.now();
    }

    public int getTotalQuantity() {
        return items.values().stream()
                .mapToInt(StockItem::getQuantity)
                .sum();
    }

    public double getTotalPrice() {
        return items.values().stream()
                .mapToDouble(StockItem::getTotalPrice)
                .sum();
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDateTime getCloseDateTime() {
        return closeDateTime;
    }

    public StockItem<? extends Product> getItem(long stockItemId) {
        return items.get(stockItemId);
    }

    public boolean isOpen() {
        return status != ReportStatus.CLOSED;
    }

    public boolean isClosed() {
        return status == ReportStatus.CLOSED;
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

    public void setItems(Map<Long, StockItem<? extends Product>> items) {
        this.items = items;
    }

    public void setStatus(ReportStatus status) {
        this.status = status;
    }

    public Collection<StockItem<? extends Product>> getItems() {
        return items.values();
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public ReportStatus getStatus() {
        return status;
    }

    public void setCloseDateTime(LocalDateTime closeDateTime) {
        this.closeDateTime = closeDateTime;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StockReport{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", comment='").append(comment).append('\'');
        sb.append(", owner='").append(customer).append('\'');
        sb.append(", items=").append(items);
        sb.append(", createdDateTime=").append(createdDateTime);
        sb.append(", closeDateTime=").append(closeDateTime);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }
}
