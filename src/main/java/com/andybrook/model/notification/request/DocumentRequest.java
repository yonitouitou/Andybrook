package com.andybrook.model.notification.request;

import com.andybrook.enums.DocType;
import com.andybrook.enums.FileFormat;
import com.andybrook.model.notification.request.ctx.DocumentCtx;

import java.util.Arrays;

public final class DocumentRequest {

    private final DocType type;
    private final FileFormat[] formats;
    private final DocumentCtx ctx;

    public DocumentRequest(DocType type, DocumentCtx ctx, FileFormat... formats) {
        this.type = type;
        this.ctx = ctx;
        this.formats = formats;
    }

    public DocType getType() {
        return type;
    }

    public FileFormat[] getFormats() {
        return formats;
    }

    public DocumentCtx getCtx() {
        return ctx;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DocumentRequest{");
        sb.append("type=").append(type);
        sb.append(", formats=").append(Arrays.toString(formats));
        sb.append('}');
        return sb.toString();
    }
}
