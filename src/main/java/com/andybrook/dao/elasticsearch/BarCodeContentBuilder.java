package com.andybrook.dao.elasticsearch;

import com.andybrook.model.BarCode;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;

import java.io.IOException;

public final class BarCodeContentBuilder implements IContentBuilder<BarCode> {

    @Override
    public XContentBuilder builder(BarCode entity) throws IOException {
        XContentBuilder builder = XContentFactory.jsonBuilder();
        builder.startObject();
        builder(builder, entity);
        return builder.endObject();
    }

    @Override
    public XContentBuilder builder(XContentBuilder builder, BarCode entity) throws IOException {
        return builder
                .field("id", entity.get())
                .field("isUsed", entity.isUsed());
    }
}
