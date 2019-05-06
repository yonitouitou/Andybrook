package com.andybrook.service.document;

import com.andybrook.model.document.AbstractDocument;

import java.util.List;

public interface IDocumentService {

    AbstractDocument get(long id);

    AbstractDocument save(AbstractDocument document);

    List<AbstractDocument> getDocumentsOfCustomer(long customerId);
}
