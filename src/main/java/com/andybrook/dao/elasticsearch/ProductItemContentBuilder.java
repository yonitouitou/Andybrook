package com.andybrook.dao.elasticsearch;

import com.andybrook.model.stock.ProductItem;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;

import java.io.IOException;

public final class ProductItemContentBuilder implements IContentBuilder<ProductItem> {

    private static final ProductContentBuilder PRODUCT_BUILDER = new ProductContentBuilder();
    private static final BarCodeContentBuilder BAR_CODE_BUILDER = new BarCodeContentBuilder();


    @Override
    public XContentBuilder builder(ProductItem entity) throws IOException {
        XContentBuilder builder = XContentFactory.jsonBuilder();
        builder.startObject();
        builder(builder, entity);
        return builder.endObject();
    }

    @Override
    public XContentBuilder builder(XContentBuilder builder, ProductItem entity) throws IOException {
        builder.field("id", entity.getId())
                .field("orderItemId", entity.getOrderItemId())
                .timeField("createdDateTime", entity.getCreatedDatetime())
                .timeField("lastModifiedDateTime", entity.getLastModifiedDatetime());
        PRODUCT_BUILDER.builder(builder, entity.getProduct());
        BAR_CODE_BUILDER.builder(builder, entity.getBarCode());
        return builder;
    }
}
