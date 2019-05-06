package com.andybrook.dao.document;

import com.andybrook.model.document.AbstractDocument;

import java.util.List;
import java.util.Optional;

public interface IDocumentDao {

    AbstractDocument save(AbstractDocument document);

    Optional<AbstractDocument> get(long id);

    List<AbstractDocument> getDocumentsOfCustomer(long customerId);
}
