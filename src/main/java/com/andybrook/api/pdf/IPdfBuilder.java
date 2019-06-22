package com.andybrook.api.pdf;

import com.andybrook.model.notification.request.ctx.OrderDocumentCtx;
import com.andybrook.model.notification.request.setting.NotifSetting;

import java.nio.file.Path;

public interface IPdfBuilder {

    Path generatePdf(OrderDocumentCtx ctx);
}
