package com.andybrook.service.notification.documentgenerator;

import com.andybrook.enums.DocType;
import com.andybrook.model.notification.handler.document.IDocumentGenerator;

public interface IDocumentGeneratorService {

    Class<IDocumentGenerator> getDocumentGenerator(DocType type);
}
