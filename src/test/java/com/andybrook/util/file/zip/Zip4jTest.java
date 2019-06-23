package com.andybrook.util.file.zip;

import com.andybrook.util.clock.Clock;
import com.andybrook.util.file.FileUtil;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public final class Zip4jTest {

    @Test
    public void zipSingleFileTest() throws IOException {
        File tempFile = File.createTempFile("" + Clock.millis(), ".tmp");
        FileUtil.writeToFile(tempFile, "MyTempFile");
        File zip = FileUtil.zip(FileUtil.TMP_DIRECTORY.toPath(), "zip-" + Clock.millis(), tempFile);
        assertZipFile(zip);
        deleteTmpFiles(tempFile, zip);
    }

    @Test
    public void zipMultipleFilesTest() throws IOException {
        int nbOfFilesToZip = 20;
        File[] filesToCompress = new File[nbOfFilesToZip];
        for (int i = 0; i < nbOfFilesToZip; i++) {
            File tempFile = File.createTempFile("" + Clock.millis() + "-" + i, ".tmp");
            FileUtil.writeToFile(tempFile, "MyTempFile-" + i);
            filesToCompress[i] = tempFile;
        }
        File zip = FileUtil.zip(FileUtil.TMP_DIRECTORY.toPath(), "zip-" + Clock.millis(), filesToCompress);
        assertZipFile(zip);
        deleteTmpFiles(filesToCompress);
        deleteTmpFiles(zip);
    }

    private static void assertZipFile(File zip) {
        Assert.assertTrue(zip.exists());
        Assert.assertTrue(FileUtil.isValidZipFile(zip.toPath()));
    }

    private static void deleteTmpFiles(File... filesToDelete) {
        for (File file : filesToDelete) {
            file.delete();
        }
    }
}
