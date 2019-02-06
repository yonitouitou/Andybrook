package com.andybrook.model.api;

import java.nio.file.Path;
import java.util.Arrays;

public class Email {

    private final String fromAddress;
    private final String[] toAddresses;
    private final String subject;
    private final String body;
    private final Path attachmentFilePath;

    Email(Builder builder) {
        fromAddress = builder.fromAddress;
        toAddresses = builder.toAddresses;
        subject = builder.subject;
        body = builder.body;
        attachmentFilePath = builder.attachmentFilePath;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public String[] getToAddresses() {
        return toAddresses;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public Path getAttachmentFilePath() {
        return attachmentFilePath;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String fromAddress;
        private String[] toAddresses;
        private String subject;
        private String body;
        private Path attachmentFilePath;

        public Builder fromAdress(String address) {
            this.fromAddress = address;
            return this;
        }

        public Builder toAdresses(String[] addresses) {
            this.toAddresses = addresses;
            return this;
        }

        public Builder withSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder withBody(String body) {
            this.body = body;
            return this;
        }

        public Builder withAttachmentFile(Path filePath) {
            this.attachmentFilePath = filePath;
            return this;
        }

        public Email build() {
            return new Email(this);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Email{");
        sb.append("fromAddress='").append(fromAddress).append('\'');
        sb.append(", toAddresses=").append(Arrays.toString(toAddresses));
        sb.append(", subject='").append(subject).append('\'');
        sb.append(", body='").append(body).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
