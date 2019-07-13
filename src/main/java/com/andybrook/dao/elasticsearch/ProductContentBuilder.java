package com.andybrook.dao.elasticsearch;

import com.andybrook.model.product.Product;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;

import java.io.IOException;

public final class ProductContentBuilder implements IContentBuilder<Product> {

    @Override
    public XContentBuilder builder(Product entity) throws IOException {
        XContentBuilder builder = XContentFactory.jsonBuilder();
        builder.startObject();
        builder(builder, entity);
        return builder.endObject();
    }

    @Override
    public XContentBuilder builder(XContentBuilder builder, Product entity) throws IOException {
        return builder
                .field("id", entity.getId())
                .field("name", entity.getName())
                .field("price", entity.getPrice());
    }
}
