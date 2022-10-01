package com.zoolatech.loganalyzer.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class FileReader implements Reader {

    private final Scanner sc;

    public FileReader(String fileName) throws FileNotFoundException {
        URL url = this.getClass().getResource(fileName);
        File file = new File(url.getPath());
        sc = new Scanner(file);
    }

    @Override
    public String nextLine() {
        if (sc.hasNextLine())
            return sc.nextLine();
        return null;
    }

}
