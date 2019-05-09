package com.andybrook.dao.jpa.entity.document;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "document")
@EntityListeners(AuditingEntityListener.class)
public class DocumentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    private String typeName;

    @Lob
    @Column(name = "data")
    private byte[] data;

    @Column(name = "orderid")
    private long orderId;

    @Column(name = "customerid")
    private long customerId;

    @CreatedDate
    private LocalDateTime createdDatetime;

    public DocumentEntity(Long id, String typeName, byte[] data, LocalDateTime createdDatetime) {
        this.id = id;
        this.typeName = typeName;
        this.data = data;
        this.createdDatetime = createdDatetime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public LocalDateTime getCreatedDatetime() {
        return createdDatetime;
    }

    public void setCreatedDatetime(LocalDateTime createdDatetime) {
        this.createdDatetime = createdDatetime;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }
}
