package com.andybrook.exception;

public class OwnerNotFound extends ValidationRuntimeException {

    public OwnerNotFound(long ownerId) {
        super(String.valueOf(ownerId));
    }
}
