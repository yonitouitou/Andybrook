package com.andybrook.manager.document;

import com.andybrook.model.document.AbstractDocument;
import com.andybrook.service.document.IDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentManager implements IDocumentManager {

    @Autowired
    private IDocumentService documentService;


    @Override
    public AbstractDocument get(long id) {
        return documentService.get(id);
    }

    @Override
    public AbstractDocument save(AbstractDocument document) {
        return documentService.save(document);
    }

    @Override
    public List<AbstractDocument> getDocumentsOfCustomer(long customerId) {
        return documentService.getDocumentsOfCustomer(customerId);
    }
}
