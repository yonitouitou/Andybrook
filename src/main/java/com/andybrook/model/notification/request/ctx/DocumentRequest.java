package com.andybrook.model.notification.request.ctx;

import com.andybrook.enums.DocType;
import com.andybrook.enums.FileFormat;

import java.util.LinkedList;
import java.util.List;

public final class DocumentRequest {

    private final DocType type;
    private final DocumentCtx ctx;
    private final List<FileFormat> formats;

    public DocumentRequest(DocType type, DocumentCtx ctx) {
        this.type = type;
        this.ctx = ctx;
        this.formats = new LinkedList<>();
    }

    public DocumentRequest(DocType type, DocumentCtx ctx, List<FileFormat> formats) {
        this.type = type;
        this.ctx = ctx;
        this.formats = formats != null ? formats : new LinkedList<>();
    }

    public void addFileFormat(FileFormat fileFormat) {
        formats.add(fileFormat);
    }

    public List<FileFormat> getFormats() {
        return formats;
    }

    public DocType getType() {
        return type;
    }

    public DocumentCtx getCtx() {
        return ctx;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DocumentRequest{");
        sb.append("type=").append(type);
        sb.append(", ctx=").append(ctx);
        sb.append(", formats=").append(formats);
        sb.append('}');
        return sb.toString();
    }
}
