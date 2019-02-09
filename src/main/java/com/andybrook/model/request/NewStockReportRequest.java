package com.andybrook.model.request;

public final class NewStockReportRequest {

    private String name;
    private String customerName;
    private String comment;

    public NewStockReportRequest() {
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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NewStockReportRequest{");
        sb.append("name='").append(name).append('\'');
        sb.append(", customerName='").append(customerName).append('\'');
        sb.append(", comment='").append(comment).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
