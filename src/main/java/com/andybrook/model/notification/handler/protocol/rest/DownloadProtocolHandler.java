package com.andybrook.model.notification.handler.protocol.rest;

import com.andybrook.annotation.NotificationProtocolHandler;
import com.andybrook.enums.NotificationType;
import com.andybrook.model.notification.DownloadNotification;
import com.andybrook.model.notification.Notification;
import com.andybrook.model.notification.handler.protocol.INotificationProtocolHandler;
import com.andybrook.model.notification.request.NotificationRequest;
import com.andybrook.model.notification.request.ctx.OrderDocumentCtx;
import com.andybrook.util.file.FileUtil;

import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

@Component
@NotificationProtocolHandler(NotificationType.DOWNLOAD)
public class DownloadProtocolHandler implements INotificationProtocolHandler {

    @Override
    public Notification handle(NotificationRequest request, List<Path> files) {
        List<Path> result = files;
        boolean withCompression = false;
        OrderDocumentCtx ctx = (OrderDocumentCtx) request.getDocumentRequest().getCtx();
        if (files.size() > 1) {
            result = zip(ctx.getOrder().getName(), files);
            withCompression = true;
        }
        return new DownloadNotification(result, withCompression);
    }

    private static List<Path> zip(String fileName, List<Path> paths) {
        File zip = FileUtil.zip(FileUtil.TMP_DIRECTORY.toPath(), fileName, paths);
        return Collections.singletonList(zip.toPath());
    }
}
