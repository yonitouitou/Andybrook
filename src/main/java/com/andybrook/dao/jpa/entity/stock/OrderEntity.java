package com.andybrook.dao.jpa.entity.stock;

import com.andybrook.dao.jpa.entity.customer.CustomerEntity;
import com.andybrook.enums.OrderStatus;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@EntityListeners(AuditingEntityListener.class)
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "name", nullable = false)
    protected String name;

    @ManyToOne
    @JoinColumn(name = "customerid", nullable = false)
    protected CustomerEntity customerEntity;

    @Column(name = "comment", length = 256)
    protected String comment;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "orderEntity")
    protected List<OrderItemEntity> items;

    @Column(name = "status")
    protected OrderStatus status;

    @Column(name = "closedatetime")
    protected LocalDateTime closeDatetime;

    @CreatedDate
    @Column(name = "createddatetime", nullable = false, updatable = false)
    protected LocalDateTime createdDatetime;

    @LastModifiedDate
    @Column(name = "lastmodifieddatetime")
    protected LocalDateTime lastModifiedDatetime;

    public OrderEntity() {
    }

    public OrderEntity(Long id, String name, CustomerEntity customerEntity,
                       OrderStatus status, String comment, LocalDateTime createdDatetime, LocalDateTime closeDateTime) {
        this.id = id;
        this.name = name;
        this.customerEntity = customerEntity;
        this.items = new ArrayList();
        this.status = status;
        this.comment = comment;
        this.createdDatetime = createdDatetime;
        this.closeDatetime = closeDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<OrderItemEntity> getItems() {
        return items;
    }

    public void setItems(List<OrderItemEntity> items) {
        this.items = items;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreatedDatetime() {
        return createdDatetime;
    }

    public void setCreatedDatetime(LocalDateTime createdDatetime) {
        this.createdDatetime = createdDatetime;
    }

    public LocalDateTime getLastModifiedDatetime() {
        return lastModifiedDatetime;
    }

    public void setLastModifiedDatetime(LocalDateTime lastModifiedDatetime) {
        this.lastModifiedDatetime = lastModifiedDatetime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getCloseDatetime() {
        return closeDatetime;
    }

    public void setCloseDatetime(LocalDateTime closeDateTime) {
        this.closeDatetime = closeDateTime;
    }

    public CustomerEntity getCustomerEntity() {
        return customerEntity;
    }

    public void setCustomerEntity(CustomerEntity customerEntity) {
        this.customerEntity = customerEntity;
    }
}
