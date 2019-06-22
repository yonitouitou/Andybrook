package com.andybrook.api.rest.ctx.notification;

import com.andybrook.enums.DocType;
import com.andybrook.enums.FileFormat;

public final class RestDocType {

    private final String type;
    private final String[] supportedFormats;

    private RestDocType(String type, String[] supportedFormats) {
        this.type = type;
        this.supportedFormats = supportedFormats;
    }

    public static RestDocType fromDocType(DocType n) {
        FileFormat[] supportedFormats = n.getSupportedFormat();
        String[] formats = new String[supportedFormats.length];
        for (int i = 0; i < supportedFormats.length; i++) {
            formats[i] = supportedFormats[i].name();
        }
        return new RestDocType(n.name(), formats);
    }

    public String getType() {
        return type;
    }

    public String[] getSupportedFormats() {
        return supportedFormats;
    }
}
