package com.andybrook.api.email;

import com.andybrook.model.api.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.*;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.nio.file.Path;
import java.util.Arrays;

@Component
public class EmailSender {

    private static final Logger LOGGER = System.getLogger(EmailSender.class.getSimpleName());

    @Autowired
    private JavaMailSender javaMailSender;

    public boolean send(Email email) {
        boolean isSent = false;
        try {
            javaMailSender.send(toMimeMailMessage(email));
            LOGGER.log(Level.INFO, "Mail sent to " + Arrays.toString(email.getToAddresses()) +
                    " with subject \"" + email.getSubject() + "\" and " + email.getAttachmentFilePath().length + " attachment(s)");
            isSent = true;
        } catch (MessagingException | IOException e) {
            LOGGER.log(Level.ERROR, "Mail not sent : " + email.getBody(), e);
        }
        return isSent;
    }

    private MimeMessage toMimeMailMessage(Email email) throws MessagingException, IOException {
        MimeMessage message = javaMailSender.createMimeMessage();
        message.setFrom(email.getFromAddress());
        message.setRecipients(RecipientType.TO, toAdresses(email.getToAddresses()));
        message.setSubject(email.getSubject());

        Multipart multipart = new MimeMultipart();
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(email.getBody(), "text/html; charset=UTF-8");
        multipart.addBodyPart(messageBodyPart);

        Path[] paths = email.getAttachmentFilePath();
        for (int i = 0; i < paths.length; i++) {
            addAttachment(multipart, paths[i]);
        }

        message.setContent(multipart);
        return message;
    }

    private void addAttachment(Multipart multipart, Path path) throws MessagingException, IOException {
        MimeBodyPart attachPart = new MimeBodyPart();
        attachPart.attachFile(path.toAbsolutePath().toString());
        multipart.addBodyPart(attachPart);
    }

    private InternetAddress[] toAdresses(String[] addresses) throws AddressException {
        InternetAddress[] array = new InternetAddress[addresses.length];
        for (int i = 0; i < addresses.length; i++) {
            array[i] = new InternetAddress(addresses[i]);
        }
        return array;
    }
}
