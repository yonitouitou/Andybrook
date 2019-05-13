package com.andybrook.api.pdf;

import com.andybrook.model.notification.request.ctx.NotifSetting;

import java.nio.file.Path;

public interface IPdfBuilder<T> {

    Path generatePdf(T object, NotifSetting setting);
}
