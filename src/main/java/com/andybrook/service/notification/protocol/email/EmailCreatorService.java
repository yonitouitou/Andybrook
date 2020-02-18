package com.andybrook.service.notification.protocol.email;

import com.andybrook.annotation.EmailOf;
import com.andybrook.enums.DocType;
import com.andybrook.exception.AnnotationNotFound;
import com.andybrook.model.notification.handler.protocol.email.IEmailCreator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.EnumMap;
import java.util.Map;

import javax.annotation.PostConstruct;

@Service
public class EmailCreatorService implements IEmailCreatorService {

    private Map<DocType, Class<IEmailCreator>> creatorClassByDocType = new EnumMap<>(DocType.class);

    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    private void init() {
        Map<String, IEmailCreator> handlerMap = applicationContext.getBeansOfType(IEmailCreator.class);
        for (IEmailCreator handler : handlerMap.values()) {
            Class<IEmailCreator> clazz = (Class<IEmailCreator>) handler.getClass();
            EmailOf annotation = clazz.getAnnotation(EmailOf.class);
            if (annotation != null) {
                DocType type = annotation.value();
                creatorClassByDocType.put(type, clazz);
            } else {
                throw new AnnotationNotFound(EmailOf.class.getSimpleName());
            }
        }
    }

    @Override
    public IEmailCreator getEmailCreator(DocType docType) {
        Class<IEmailCreator> clazz = creatorClassByDocType.get(docType);
        return applicationContext.getBean(clazz);
    }
}
