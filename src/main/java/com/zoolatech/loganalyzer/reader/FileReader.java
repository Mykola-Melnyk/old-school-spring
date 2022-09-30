package com.zoolatech.loganalyzer.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class FileReader implements Reader {

    private String fileName;

    public FileReader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String nextLine() throws FileNotFoundException {
        List<String> lines = new ArrayList<>();
        URL url = this.getClass().getResource(fileName);
        File file = new File(url.getPath());
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine())
            lines.add(sc.nextLine());
        Iterator<String> iterator = lines.iterator();
        if (iterator.hasNext()) {
            return iterator.next();
        }
        return null;
    }

}
