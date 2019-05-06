package com.andybrook.dao.document;

import com.andybrook.dao.jpa.entity.document.DocumentEntity;
import org.springframework.data.repository.CrudRepository;

public interface IDocumentCrudRepository extends CrudRepository<DocumentEntity, Long> {
}
