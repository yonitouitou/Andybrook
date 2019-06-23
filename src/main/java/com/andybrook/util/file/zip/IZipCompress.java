package com.andybrook.util.file.zip;

import java.io.File;
import java.nio.file.Path;

public interface IZipCompress {

    File zip(Path destinationFolder, String fileName, File... files);

    boolean isValidZipFile(Path zipFilePath);
}
