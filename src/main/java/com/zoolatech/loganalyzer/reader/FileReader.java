package com.zoolatech.loganalyzer.reader;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class FileReader implements Reader {

    private final Scanner sc;

    public FileReader(String fileName) throws FileNotFoundException {
        InputStream stream = this.getClass().getResourceAsStream(fileName);
        if (stream != null) {
            sc = new Scanner(stream, StandardCharsets.UTF_8);
        } else {
            throw new FileNotFoundException("File " + fileName + " not found.");
        }
    }

    @Override
    public String nextLine() {
        if (sc.hasNextLine())
            return sc.nextLine();
        return null;
    }

}
