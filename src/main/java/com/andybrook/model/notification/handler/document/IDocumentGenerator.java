package com.andybrook.model.notification.handler.document;

import com.andybrook.model.notification.request.ctx.DocumentRequest;

import java.nio.file.Path;
import java.util.List;

public interface IDocumentGenerator {

    List<Path> generate(DocumentRequest request);
}
