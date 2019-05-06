package com.andybrook.dao.document;

import com.andybrook.dao.jpa.entity.document.DocumentEntity;
import com.andybrook.dao.jpa.entity.factory.EntityFactory;
import com.andybrook.model.document.AbstractDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DocumentDao implements IDocumentDao {

    @Autowired
    private IDocumentCrudRepository repository;
    @Autowired
    private EntityFactory entityFactory;

    @Override
    public AbstractDocument save(AbstractDocument document) {
        DocumentEntity entity = entityFactory.createDocumentEntity(document);
        DocumentEntity savedEntity = repository.save(entity);
        return entityFactory.createDocument(savedEntity);
    }

    @Override
    public Optional<AbstractDocument> get(long id) {
        Optional<AbstractDocument> docOpt = Optional.empty();
        Optional<DocumentEntity> entityOpt = repository.findById(id);
        if (entityOpt.isPresent()) {
            docOpt = Optional.of(entityFactory.createDocument(entityOpt.get()));
        }
        return docOpt;
    }

    @Override
    public List<AbstractDocument> getDocumentsOfCustomer(long customerId) {
        return null;
    }
}
