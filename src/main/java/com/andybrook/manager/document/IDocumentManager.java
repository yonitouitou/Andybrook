package com.andybrook.manager.document;

import com.andybrook.model.document.AbstractDocument;

import java.util.List;

public interface IDocumentManager {

    AbstractDocument get(long id);

    AbstractDocument save(AbstractDocument document);

    List<AbstractDocument> getDocumentsOfCustomer(long customerId);
}
