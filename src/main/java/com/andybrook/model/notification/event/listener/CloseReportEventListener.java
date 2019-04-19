package com.andybrook.model.notification.event.listener;

import com.andybrook.api.email.EmailSender;
import com.andybrook.model.order.Order;
import com.andybrook.model.notification.IEmailNotification;
import com.andybrook.model.notification.OrderClosedEmailNotification;
import com.andybrook.model.notification.event.ctx.CloseReportEvent;
import com.andybrook.model.setting.AdminSetting;
import com.andybrook.service.setting.IAdminSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CloseReportEventListener implements IEventListener<CloseReportEvent> {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private EmailSender emailSender;
    @Autowired
    private IAdminSettingService adminSettingService;

    @Override
    @EventListener
    public void handleEvent(CloseReportEvent event) {
        IEmailNotification<Order> closedReportNotif = applicationContext.getBean(OrderClosedEmailNotification.class);
        AdminSetting adminSetting = adminSettingService.getAdminSetting();
        emailSender.send(closedReportNotif.createEmail(adminSetting, event.getReport()));
    }
}
