package com.zoolatech.loganalyzer.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class FileReader implements Reader {

    private final Scanner sc;

    public FileReader(String fileName) {
        InputStream stream = this.getClass().getResourceAsStream(fileName);
        sc = new Scanner(stream, StandardCharsets.UTF_8);
    }

    @Override
    public String nextLine() {
        if (sc.hasNextLine())
            return sc.nextLine();
        return null;
    }

}
