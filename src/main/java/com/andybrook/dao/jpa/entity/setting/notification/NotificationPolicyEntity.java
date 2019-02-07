package com.andybrook.dao.jpa.entity.setting.notification;

import javax.persistence.*;

@Entity
@Table(name = "notification_policy")
public class NotificationPolicyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "onclosereport", nullable = false)
    private boolean onCloseReport = false;

    public NotificationPolicyEntity(Long id, boolean onCloseReport) {
        this.id = id;
        this.onCloseReport = onCloseReport;
    }

    public Long getId() {
        return id;
    }

    public boolean onCloseReport() {
        return onCloseReport;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NotificationPolicyEntity{");
        sb.append("id=").append(id);
        sb.append(", onCloseReport=").append(onCloseReport);
        sb.append('}');
        return sb.toString();
    }
}
