package com.andybrook.dao.stock;

import com.andybrook.exception.SerializerException;
import com.andybrook.exception.fileupload.StockItemsFileUploadException;
import com.andybrook.model.api.StockItemsFileUpload;
import com.andybrook.serialization.ISerializer;
import com.andybrook.serialization.jackson.JacksonSerializer;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
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

    private static System.Logger LOGGER = System.getLogger(StockItemsFileUploadDao.class.getSimpleName());
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
                    .source(data, XContentType.JSON);
            response = client.index(indexRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            throw new StockItemsFileUploadSaveException(e);
        }
        return response.getId();
    }

    @Override
    public StockItemsFileUpload getById(String uploadId) {
        StockItemsFileUpload result;
        try {
            GetRequest req = new GetRequest(INDEX_NAME, uploadId);
            GetResponse response = client.get(req, RequestOptions.DEFAULT);
            result = SERIALIZER.deserialize(response.getSourceAsString(), StockItemsFileUpload.class);
        } catch (IOException e) {
            throw new StockItemsFileUploadGetException();
        } catch (SerializerException e) {
            LOGGER.log(System.Logger.Level.ERROR, "Exception on deserialization", e);
            throw e;
        }
        return result;
    }

    private class StockItemsFileUploadSaveException extends StockItemsFileUploadException {
        public StockItemsFileUploadSaveException(Throwable cause) {
            super(cause);
        }
    }
    private class StockItemsFileUploadGetException extends StockItemsFileUploadException {}
}
