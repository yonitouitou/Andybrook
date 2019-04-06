package com.andybrook.exception;

import com.andybrook.language.Msg.Error;

public class StoreNotFound extends ValidationRuntimeException {

    public StoreNotFound(long id) {
        super(Error.STORE_NOT_FOUND + " " + id);
    }
}
