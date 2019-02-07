package com.andybrook.dao.jpa.entity.setting;

import com.andybrook.dao.jpa.entity.setting.notification.NotificationPolicyEntity;

import javax.persistence.*;

@Entity
@Table(name = "setting_admin")
public class AdminSettingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String email;

    @OneToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "notificationpolicyid", referencedColumnName = "id", nullable = false)
    private NotificationPolicyEntity notificationPolicyEntity;

    public AdminSettingEntity(Long id, String email, NotificationPolicyEntity notificationPolicyEntity) {
        this.id = id;
        this.email = email;
        this.notificationPolicyEntity = notificationPolicyEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public NotificationPolicyEntity getNotificationPolicyEntity() {
        return notificationPolicyEntity;
    }

    public void setNotificationPolicyEntity(NotificationPolicyEntity notificationPolicyEntity) {
        this.notificationPolicyEntity = notificationPolicyEntity;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AdminSettingEntity{");
        sb.append("id=").append(id);
        sb.append(", email='").append(email).append('\'');
        sb.append(", notificationPolicyEntity=").append(notificationPolicyEntity);
        sb.append('}');
        return sb.toString();
    }
}
