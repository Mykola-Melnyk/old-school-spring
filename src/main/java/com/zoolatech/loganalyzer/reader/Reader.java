package com.zoolatech.loganalyzer.reader;

import java.io.FileNotFoundException;

public interface Reader {

    String nextLine() throws FileNotFoundException;

}
