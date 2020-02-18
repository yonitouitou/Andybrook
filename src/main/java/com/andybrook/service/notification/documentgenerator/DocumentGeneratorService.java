package com.andybrook.service.notification.documentgenerator;

import com.andybrook.annotation.DocumentGenerator;
import com.andybrook.enums.DocType;
import com.andybrook.exception.AnnotationNotFound;
import com.andybrook.model.notification.handler.document.IDocumentGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.EnumMap;
import java.util.Map;

import javax.annotation.PostConstruct;

@Service
public class DocumentGeneratorService implements IDocumentGeneratorService {

    @Autowired
    private ApplicationContext applicationContext;

    private Map<DocType, Class<IDocumentGenerator>> handlerClassMapByType = new EnumMap<>(DocType.class);

    @PostConstruct
    private void init() {
        Map<String, IDocumentGenerator> handlerMap = applicationContext.getBeansOfType(IDocumentGenerator.class);
        for (IDocumentGenerator handler : handlerMap.values()) {
            Class<IDocumentGenerator> clazz = (Class<IDocumentGenerator>) handler.getClass();
            DocumentGenerator annotation = clazz.getAnnotation(DocumentGenerator.class);
            if (annotation != null) {
                DocType type = annotation.type();
                handlerClassMapByType.put(type, clazz);
            } else {
                throw new AnnotationNotFound(DocumentGenerator.class.getSimpleName());
            }
        }
    }

    @Override
    public Class<IDocumentGenerator> getDocumentGenerator(DocType type) {
        return handlerClassMapByType.get(type);
    }
}
