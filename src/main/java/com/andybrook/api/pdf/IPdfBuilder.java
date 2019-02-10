package com.andybrook.api.pdf;

import java.nio.file.Path;

public interface IPdfBuilder<T> {

    Path generatePdf(T object);
}
