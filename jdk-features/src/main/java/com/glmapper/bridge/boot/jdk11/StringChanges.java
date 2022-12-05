package com.glmapper.bridge.boot.jdk11;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class StringChanges {

    public static void main(String[] args) throws Exception {
        test();
        test_file();
    }

    /**
     * isBlank, lines, strip, stripLeading, stripTrailing, and repeat.
     */
    public static void test() {
        String multilineString = "hello glmapper \n \n i am openjdk17 \n nice to meet you.";
        List<String> lines = multilineString.lines()
                .filter(line -> !line.isBlank())
                .map(String::strip)
                .collect(Collectors.toList());
        System.out.println(lines);
    }


    /**
     * readString and writeString
     * @throws Exception
     */
    public static void test_file() throws Exception {
        String tempDir = System.getProperty("user.home");
        Path path = Path.of(tempDir);
        Path filePath = Files.writeString(Files.createTempFile(path, "demo", ".txt"), "Sample text");
        String fileContent = Files.readString(filePath);
        System.out.println(fileContent);
        File file = filePath.toFile();
        file.deleteOnExit();
    }
}
