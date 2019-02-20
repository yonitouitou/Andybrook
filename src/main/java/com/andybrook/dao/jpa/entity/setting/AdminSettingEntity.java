package com.andybrook.dao.jpa.entity.setting;

import com.andybrook.dao.jpa.entity.setting.notification.NotificationPolicyEntity;

import javax.persistence.*;
import java.awt.*;

@Entity
@Table(name = "setting_admin")
public class AdminSettingEntity {

    private static final int DEFAULT_ORDERS_TO_SHOW_10 = 10;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ordersnbtoshow")
    private int ordersNbToShow = DEFAULT_ORDERS_TO_SHOW_10;

    @Column(name = "email")
    private String email;

    @Column(name = "documentbackgroundheadertablecolor")
    private int documentBackgroundHeaderTableColorRgb;

    @Column(name = "documenttextheadertablecolor")
    private int documentTextHeaderTableColorRgb;

    @OneToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "notificationpolicyid", referencedColumnName = "id", nullable = false)
    private NotificationPolicyEntity notificationPolicyEntity;

    private AdminSettingEntity(){
    }

    public AdminSettingEntity(Long id, int ordersNbToShow, String email, NotificationPolicyEntity notificationPolicyEntity,
                                int documentBackgroundHeaderTableColorRgb, int documentTextHeaderTableColorRgb) {
        this.id = id;
        this.email = email;
        this.ordersNbToShow = ordersNbToShow > 0 ? ordersNbToShow : DEFAULT_ORDERS_TO_SHOW_10;
        this.documentBackgroundHeaderTableColorRgb = documentBackgroundHeaderTableColorRgb > 0 ? documentBackgroundHeaderTableColorRgb : Color.LIGHT_GRAY.getRGB();
        this.documentTextHeaderTableColorRgb = documentTextHeaderTableColorRgb > 0 ? documentTextHeaderTableColorRgb : Color.BLACK.getRGB();
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

    public int getOrdersNbToShow() {
        return ordersNbToShow;
    }

    public void setOrdersNbToShow(int ordersNbToShow) {
        this.ordersNbToShow = ordersNbToShow;
    }

    public int getDocumentBackgroundHeaderTableColorRgb() {
        return documentBackgroundHeaderTableColorRgb;
    }

    public void setDocumentBackgroundHeaderTableColorRgb(int documentBackgroundHeaderTableColorRgb) {
        this.documentBackgroundHeaderTableColorRgb = documentBackgroundHeaderTableColorRgb;
    }

    public int getDocumentTextHeaderTableColorRgb() {
        return documentTextHeaderTableColorRgb;
    }

    public void setDocumentTextHeaderTableColorRgb(int documentTextHeaderTableColorRgb) {
        this.documentTextHeaderTableColorRgb = documentTextHeaderTableColorRgb;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AdminSettingEntity{");
        sb.append("id=").append(id);
        sb.append(", ordersNbToShow=").append(ordersNbToShow);
        sb.append(", email='").append(email).append('\'');
        sb.append(", documentBackgroundHeaderTableColorRgb=").append(documentBackgroundHeaderTableColorRgb);
        sb.append(", documentTextHeaderTableColorRgb=").append(documentTextHeaderTableColorRgb);
        sb.append(", notificationPolicyEntity=").append(notificationPolicyEntity);
        sb.append('}');
        return sb.toString();
    }
}
