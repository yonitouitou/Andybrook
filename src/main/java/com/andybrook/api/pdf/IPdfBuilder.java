package com.andybrook.api.pdf;

import com.andybrook.model.notification.ctx.DocSetting;

import java.nio.file.Path;

public interface IPdfBuilder<T> {

    Path generatePdf(T object, DocSetting setting);
}
