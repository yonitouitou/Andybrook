package com.andybrook.dao.jpa.entity.setting.notification;

import com.andybrook.annotation.EntityConverter;
import com.andybrook.dao.jpa.entity.factory.IEntityConverter;
import com.andybrook.model.notification.NotificationPolicy;
import org.springframework.stereotype.Component;

@Component
@EntityConverter(model = NotificationPolicy.class, entity = NotificationPolicyEntity.class)
public class NotificationPolicyConverter implements IEntityConverter<NotificationPolicy, NotificationPolicyEntity> {

    @Override
    public NotificationPolicy toModel(NotificationPolicyEntity entity) {
        NotificationPolicy policy = new NotificationPolicy(entity.getId());
        policy.setOnCloseReport(entity.onCloseReport());
        return policy;
    }

    @Override
    public NotificationPolicyEntity toEntity(NotificationPolicy model) {
        return new NotificationPolicyEntity(model.getId(), model.onCloseReport());
    }
}
