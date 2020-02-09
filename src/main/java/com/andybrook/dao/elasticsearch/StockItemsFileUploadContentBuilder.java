package com.andybrook.dao.elasticsearch;

import com.andybrook.model.api.StockItemsFileUpload;

import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;

import java.io.IOException;

public final class StockItemsFileUploadContentBuilder implements IContentBuilder<StockItemsFileUpload> {

    private static final ProductItemContentBuilder PRODUCT_ITEM_BUILDER = new ProductItemContentBuilder();

    @Override
    public XContentBuilder builder(StockItemsFileUpload entity) throws IOException {
        XContentBuilder builder = XContentFactory.jsonBuilder();
        builder.startObject();
        builder(builder, entity);
        return builder.endObject();
    }

    @Override
    public XContentBuilder builder(XContentBuilder builder, StockItemsFileUpload entity) throws IOException {
        return null;
       /* builder
                .field("id", entity.getId())
                .field("rowsInFile", entity.getRowsInFile())
                .field("rowsProcessed", entity.getRowsProcessed())
                .field("uploadDateTime", entity.getUploadTimestamp())
                .field("productItems", entity.getProductsForUpload());
        for (ProductItem productItem : entity.getProductsForUpload()) {
            PRODUCT_ITEM_BUILDER.builder(builder, productItem);
        }
        builder.endArray();
        return builder;*/
    }
}
