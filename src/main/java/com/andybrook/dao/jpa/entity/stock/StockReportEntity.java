package com.andybrook.dao.jpa.entity.stock;

import com.andybrook.enums.ReportStatus;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "stock_report")
@EntityListeners(AuditingEntityListener.class)
public class StockReportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "name", nullable = false)
    protected String name;

    @Column(name = "comment", nullable = true, length = 256)
    protected String comment;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id", cascade = CascadeType.ALL)
    //@JoinColumn(name="stockreportid", referencedColumnName = "id", nullable=false)
    protected List<StockItemEntity> items;

    @Column(name = "status")
    protected ReportStatus status;

    @CreatedDate
    @Column(name = "createddatetime")
    protected LocalDateTime createdDatetime;

    @LastModifiedDate
    @Column(name = "lastmodifieddatetime")
    protected LocalDateTime lastModifiedDatetime;

    public StockReportEntity() {
    }

    public StockReportEntity(Long id, String name, List<StockItemEntity> items, ReportStatus status) {
        this.id = id;
        this.name = name;
        this.items = items;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<StockItemEntity> getItems() {
        return items;
    }

    public void setItems(List<StockItemEntity> items) {
        this.items = items;
    }

    public ReportStatus getStatus() {
        return status;
    }

    public void setStatus(ReportStatus status) {
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
}