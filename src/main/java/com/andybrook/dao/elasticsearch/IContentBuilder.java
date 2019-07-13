package com.andybrook.dao.elasticsearch;

import org.elasticsearch.common.xcontent.XContentBuilder;

import java.io.IOException;

public interface IContentBuilder<T> {

    XContentBuilder builder(T entity) throws IOException;

    XContentBuilder builder(XContentBuilder builder, T entity) throws IOException;
}
