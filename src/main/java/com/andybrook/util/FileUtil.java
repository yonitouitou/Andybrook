package com.andybrook.util;

import org.apache.commons.io.FilenameUtils;

public final class FileUtil {

    public static String getExtension(String fileName) {
        return FilenameUtils.getExtension(fileName);
    }
}
