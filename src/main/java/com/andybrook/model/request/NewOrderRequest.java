package com.andybrook.model.request;

public final class NewOrderRequest {

    private String name;
    private long customerId;
    private String comment;

    public NewOrderRequest() {
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

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NewOrderRequest{");
        sb.append("name='").append(name).append('\'');
        sb.append(", customerId=").append(customerId);
        sb.append(", comment='").append(comment).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
