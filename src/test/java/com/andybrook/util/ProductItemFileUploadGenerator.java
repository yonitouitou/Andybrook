package com.andybrook.util;

import com.andybrook.service.api.ProductItemFileParserServiceTest;
import com.andybrook.util.clock.Clock;
import com.andybrook.util.file.FileUtil;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class ProductItemFileUploadGenerator {

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    public static File generateProductFile(int linesNb) throws IOException {
        String content = generateFileContent(linesNb);
        File file = new File(FileUtil.TMP_DIRECTORY, "Test-" + Clock.millis() + ".csv");
        FileUtil.writeToFile(file, content);
        return file;
    }

    private static String generateFileContent(int linesNb) {
        StringBuilder sb = new StringBuilder();
        generateColumnsLine(sb);
        for (int i = 0; i < linesNb; i++) {
            generateProductLine(sb);
            if (i != linesNb - 1) {
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
    private static void generateColumnsLine(StringBuilder sb) {
        sb.append(ProductItemFileParserServiceTest.getColumnsRow()).append(System.lineSeparator());
    }

    private static void generateProductLine(StringBuilder sb) {
        sb.append("A-" + Clock.nanos()).append(";")
                .append(RANDOM.nextInt(10, 500)).append(";");
        int limit = RANDOM.nextInt(1, 3);
        for (int i = 0; i < limit; i++) {
            sb.append(UUID.randomUUID().toString());
            if (i != limit -1) {
                sb.append(",");
            }
        }
    }
}
