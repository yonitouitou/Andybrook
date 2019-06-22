package com.andybrook.api.rest.ctx.notification;

import com.andybrook.enums.DocType;
import com.andybrook.enums.FileFormat;
import com.andybrook.enums.NotificationType;

import java.util.Arrays;
import java.util.List;

public class DocumentRestRequest extends NotificationRestRequest {

    protected DocType docType;
    protected long dateDocument;
    protected FileFormat[] fileFormats;
    protected String[] emails;

    public DocumentRestRequest(NotificationType[] notifTypes, DocType docType, long dateDocument,
                               FileFormat[] fileFormats, String[] emails) {
        super(notifTypes);
        this.docType = docType;
        this.dateDocument = dateDocument;
        this.fileFormats = fileFormats;
        this.emails = emails;
    }

    public long getDateDocument() {
        return dateDocument;
    }

    public void setDateDocument(long dateDocument) {
        this.dateDocument = dateDocument;
    }

    public DocType getDocType() {
        return docType;
    }

    public void setType(DocType docType) {
        this.docType = docType;
    }

    public DocumentRestRequest setDocType(DocType docType) {
        this.docType = docType;
        return this;
    }

    public FileFormat[] getFileFormats() {
        return fileFormats;
    }

    public DocumentRestRequest setFileFormats(FileFormat[] fileFormats) {
        this.fileFormats = fileFormats;
        return this;
    }

    public String[] getEmails() {
        return emails;
    }

    public DocumentRestRequest setEmails(String[] emails) {
        this.emails = emails;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DocumentRestRequest{");
        sb.append("docType=").append(docType);
        sb.append(", dateDocument=").append(dateDocument);
        sb.append(", fileFormats=").append(Arrays.toString(fileFormats));
        sb.append(", emails=").append(Arrays.toString(emails));
        sb.append('}');
        return sb.toString();
    }
}
