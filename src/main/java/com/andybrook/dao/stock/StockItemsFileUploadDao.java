package com.andybrook.dao.stock;

import com.andybrook.exception.fileupload.StockItemsFileUploadException;
import com.andybrook.model.api.StockItemsFileUpload;
import com.andybrook.serialization.ISerializer;
import com.andybrook.serialization.JacksonSerializer;
import com.andybrook.util.IdGenerator;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
public class StockItemsFileUploadDao implements IStockItemsFileUploadDao {

    private static final ISerializer SERIALIZER = new JacksonSerializer();
    private static final String INDEX_NAME = "stock_items_file_upload";

    @Autowired
    private RestHighLevelClient client;

    @Override
    public String saveProductFileUpload(StockItemsFileUpload upload) {
        IndexResponse response = null;
        try {
            String data = SERIALIZER.serializeToString(upload);
            IndexRequest indexRequest = new IndexRequest()
                    .index(INDEX_NAME)
                    .id(IdGenerator.generateAlfaNumericId())
                    .source(data, XContentType.JSON)
                    .create(true);
            response = client.index(indexRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            throw new StockItemsFileUploadSaveException();
        }
        return response.getId();
    }

    private class StockItemsFileUploadSaveException extends StockItemsFileUploadException {}
}
