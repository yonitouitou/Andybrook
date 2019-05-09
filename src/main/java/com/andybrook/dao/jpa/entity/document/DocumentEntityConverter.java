package com.andybrook.dao.jpa.entity.document;

import com.andybrook.annotation.EntityConverter;
import com.andybrook.dao.jpa.entity.factory.IEntityConverter;
import com.andybrook.enums.DocType;
import com.andybrook.model.document.AbstractDocument;
import com.andybrook.model.document.order.OrderForm;
import org.springframework.stereotype.Component;

@Component
@EntityConverter(model = AbstractDocument.class, entity = DocumentEntity.class)
public class DocumentEntityConverter implements IEntityConverter<AbstractDocument, DocumentEntity> {

    @Override
    public AbstractDocument toModel(DocumentEntity entity) {
        AbstractDocument doc;
        if (DocType.ORDER_FORM.getName().equals(entity.getTypeName())) {
            doc = new OrderForm(entity.getId(), entity.getData(), entity.getCreatedDatetime(),
                    entity.getOrderId(), entity.getCustomerId());
        } else {
            throw new UnsupportedOperationException("Unsupported Document Type : " + entity.getTypeName());
        }
        return doc;
    }

    @Override
    public DocumentEntity toEntity(AbstractDocument model) {
        DocumentEntity entity;
        if (DocType.ORDER_FORM == model.getType()) {
            entity = buildEntityFromOrderForm((OrderForm) model);
        } else {
            throw new UnsupportedOperationException("Unsupported Document Type : " + model.getType());
        }
        return entity;
    }

    private DocumentEntity buildEntityFromOrderForm(OrderForm model) {
        DocumentEntity entity = new DocumentEntity(model.getId(), model.getType().getName(), model.getData(), model.getCreatedDatetime());
        entity.setOrderId(model.getOrderId());
        entity.setCustomerId(model.getCustomerId());
        return entity;
    }
}
