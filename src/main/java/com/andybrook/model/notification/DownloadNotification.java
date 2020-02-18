package com.andybrook.model.notification;

import com.andybrook.enums.NotificationType;

import java.nio.file.Path;
import java.util.List;

public class DownloadNotification extends Notification {

    private final List<Path> downloadedFiles;
    private final boolean filesCompressed;

    public DownloadNotification(List<Path> downloadedFiles, boolean filesCompressed) {
        super(NotificationType.DOWNLOAD);
        this.downloadedFiles = downloadedFiles;
        this.filesCompressed = filesCompressed;
    }

    public List<Path> getDownloadedFiles() {
        return downloadedFiles;
    }

    public boolean isFilesCompressed() {
        return filesCompressed;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DownloadNotification{");
        sb.append("downloadedFiles=").append(downloadedFiles);
        sb.append('}');
        return sb.toString();
    }
}
