package com.andybrook.util.file.zip;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.nio.file.Path;

public class Zip4j implements IZipCompress {

    @Override
    public File zip(Path destinationFolder, String fileName, File... files) throws ZipFileException {
        File finalZip;
        int count = 1;
        try {
            File destinationFile = new File(destinationFolder.toFile(), fileName + ".zip");
            while (destinationFile.exists()) {
                destinationFile = new File(destinationFile.getParent(), FilenameUtils.getBaseName(destinationFile.getName()) + " (" + count++ + ").zip");
            }
            ZipFile zip = new ZipFile(destinationFile);
            ZipParameters params = new ZipParameters();
            for (File file : files) {
                zip.addFile(file, params);
            }
            finalZip = zip.getFile();
        } catch (ZipException e) {
            throw new ZipFileException(e);
        }
        return finalZip;
    }

    @Override
    public boolean isValidZipFile(Path zipFilePath) {
        boolean isValid;
        try {
            ZipFile zip = new ZipFile(zipFilePath.toAbsolutePath().toString());
            isValid = zip.isValidZipFile();
        } catch (ZipException e) {
            throw new ZipFileException(e);
        }
        return isValid;
    }

    private class ZipFileException extends RuntimeException {

        private ZipFileException(Exception e) {
            super(e);
        }
    }
}
