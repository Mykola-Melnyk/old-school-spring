package com.zoolatech.loganalyzer.reader;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class FileReader implements Reader {

    private Scanner sc;
    private final String fileName;

    public FileReader(String fileName) throws IOException {
        this.fileName = fileName;
        reset();
    }

    @Override
    public String nextLine() {
        if (sc.hasNextLine())
            return sc.nextLine();
        return null;
    }

    @Override
    public void reset() throws IOException {
        InputStream stream = this.getClass().getResourceAsStream(fileName);
        if (stream != null) {
            sc = new Scanner(stream, StandardCharsets.UTF_8);
        } else {
            throw new IOException("File " + fileName + " not found.");
        }
    }

    @Override
    public void close() {
        sc.close();
    }

}
