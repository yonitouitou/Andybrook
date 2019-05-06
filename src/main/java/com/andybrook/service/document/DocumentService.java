package com.andybrook.service.document;

import com.andybrook.dao.document.IDocumentDao;
import com.andybrook.exception.DocumentNotFound;
import com.andybrook.model.document.AbstractDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentService implements IDocumentService {

    @Autowired
    private IDocumentDao dao;

    @Override
    public AbstractDocument get(long id) {
        Optional<AbstractDocument> docOpt = dao.get(id);
        return docOpt.orElseThrow(() -> new DocumentNotFound(id));
    }

    @Override
    public AbstractDocument save(AbstractDocument document) {
        return dao.save(document);
    }

    @Override
    public List<AbstractDocument> getDocumentsOfCustomer(long customerId) {
        return null;
    }
}
