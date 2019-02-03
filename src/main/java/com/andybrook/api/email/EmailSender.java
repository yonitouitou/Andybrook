package com.andybrook.api.email;

import com.andybrook.model.api.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {

    @Autowired
    private JavaMailSender javaMailSender;

    public boolean send(Email email) {
        javaMailSender.send(toSimpleMailMessage(email));
        return true;
    }

    private SimpleMailMessage toSimpleMailMessage(Email email) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(email.getFromAddress());
        msg.setTo(email.getToAddresses());
        msg.setSubject(email.getSubject());
        msg.setText(email.getBody());
        return msg;
    }
}
