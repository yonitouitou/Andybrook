package com.andybrook.service.notification.protocol.email;

import com.andybrook.enums.DocType;
import com.andybrook.model.notification.handler.protocol.email.IEmailCreator;

public interface IEmailCreatorService {

    IEmailCreator getEmailCreator(DocType docType);
}
