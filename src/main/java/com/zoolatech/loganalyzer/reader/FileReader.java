package com.zoolatech.loganalyzer.reader;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class FileReader implements Reader {

    private final Scanner sc;

    public FileReader(String fileName) throws IOException {
        InputStream stream = this.getClass().getResourceAsStream(fileName);
        if (stream != null) {
            sc = new Scanner(stream, StandardCharsets.UTF_8);
        } else {
            throw new IOException("File " + fileName + " not found.");
        }
    }

    @Override
    public String nextLine() {
        if (sc.hasNextLine())
            return sc.nextLine();
        return null;
    }

    @Override
    public void close() {
        sc.close();
    }

}
