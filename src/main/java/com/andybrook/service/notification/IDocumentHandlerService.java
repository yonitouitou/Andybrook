package com.andybrook.service.notification;

import com.andybrook.enums.DocType;
import com.andybrook.model.notification.handler.IDocumentHandler;

public interface IDocumentHandlerService {

    Class<IDocumentHandler> getHandler(DocType type);
}
