package com.andybrook.api.email;

import com.andybrook.model.api.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;

@Component
public class EmailSender {

    private static final Logger LOGGER = System.getLogger(EmailSender.class.getSimpleName());

    @Autowired
    private JavaMailSender javaMailSender;

    public boolean send(Email email) {
        boolean isSent = false;
        try {
            javaMailSender.send(toMimeMailMessage(email));
            isSent = true;
        } catch (MessagingException e) {
            LOGGER.log(Level.ERROR, "Mail not sent : " + email.getBody(), e);
        }
        return isSent;
    }

    private MimeMessage toMimeMailMessage(Email email) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(email.getFromAddress());
        helper.setTo(email.getToAddresses());
        helper.setSubject(email.getSubject());
        helper.setText(email.getBody(), true);
        helper.addAttachment(email.getAttachmentFilePath().getFileName().toString(), email.getAttachmentFilePath().toFile());
        return message;
    }
}
