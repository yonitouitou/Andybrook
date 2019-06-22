package com.andybrook.service.notification;

import com.andybrook.annotation.DocumentHandler;
import com.andybrook.enums.DocType;
import com.andybrook.enums.NotificationType;
import com.andybrook.exception.AnnotationNotFound;
import com.andybrook.model.notification.handler.IDocumentHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.EnumMap;
import java.util.Map;

@Service
public class DocumentHandlerService implements IDocumentHandlerService {

    @Autowired
    private ApplicationContext applicationContext;

    private Map<DocType, Class<IDocumentHandler>> handlerClassMapByType = new EnumMap<>(DocType.class);

    @PostConstruct
    private void init() {
        Map<String, IDocumentHandler> handlerMap = applicationContext.getBeansOfType(IDocumentHandler.class);
        for (IDocumentHandler handler : handlerMap.values()) {
            Class<IDocumentHandler> clazz = (Class<IDocumentHandler>) handler.getClass();
            DocumentHandler annotation = clazz.getAnnotation(DocumentHandler.class);
            if (annotation != null) {
                DocType type = annotation.type();
                handlerClassMapByType.put(type, clazz);
            } else {
                throw new AnnotationNotFound(DocumentHandler.class.getSimpleName());
            }
        }
    }

    @Override
    public Class<IDocumentHandler> getHandler(DocType type) {
        return handlerClassMapByType.get(type);
    }
}
