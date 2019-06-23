package com.andybrook.util.file;

import com.andybrook.util.file.zip.IZipCompress;
import com.andybrook.util.file.zip.Zip4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public final class FileUtil {

    public static final File TMP_DIRECTORY = new File("/tmp");
    private static final IZipCompress ZIP = new Zip4j();

    public static String getExtension(String fileName) {
        return FilenameUtils.getExtension(fileName);
    }

    public static File zip(Path destinationFolder, String fileName, File... files) {
        return ZIP.zip(destinationFolder, fileName, files);
    }

    public static File zip(Path destinationFolder, String fileName, List<Path> paths) {
        Objects.requireNonNull(destinationFolder);
        Objects.requireNonNull(paths);
        File[] files = new File[paths.size()];
        for (int i = 0; i < files.length; i++) {
            Path path = paths.get(i);
            if (path != null) {
                files[i] = path.toFile();
            }
        }
        return ZIP.zip(destinationFolder, fileName, files);
    }

    public static boolean isValidZipFile(Path zip) {
        return ZIP.isValidZipFile(zip);
    }

    public static void writeToFile(File file, String data) throws IOException {
        FileUtils.writeStringToFile(file, data, "UTF-8");
    }
}
