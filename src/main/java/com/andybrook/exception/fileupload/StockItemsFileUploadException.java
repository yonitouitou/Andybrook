package com.andybrook.exception.fileupload;

public class StockItemsFileUploadException extends RuntimeException {

    public StockItemsFileUploadException() {
    }

    public StockItemsFileUploadException(String message) {
        super(message);
    }

    public StockItemsFileUploadException(String message, Throwable cause) {
        super(message, cause);
    }

    public StockItemsFileUploadException(Throwable cause) {
        super(cause);
    }

    public StockItemsFileUploadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
