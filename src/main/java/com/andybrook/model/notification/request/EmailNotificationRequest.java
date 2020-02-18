package com.andybrook.model.notification.request;

import com.andybrook.enums.NotificationType;
import com.andybrook.model.notification.request.ctx.DocumentRequest;

import java.util.LinkedList;
import java.util.List;

public class EmailNotificationRequest extends NotificationRequest {

    private List<String> addresses;

    public EmailNotificationRequest(boolean isLiveEvent, DocumentRequest documentRequest) {
        super(NotificationType.EMAIL, isLiveEvent, documentRequest);
        this.addresses = new LinkedList<>();
    }

    public void addAddress(String address) {
        addresses.add(address);
    }

    public List<String> getAddresses() {
        return addresses;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EmailNotificationRequest{");
        sb.append("addresses=").append(addresses);
        sb.append('}');
        return sb.toString();
    }
}
