package com.zoolatech.loganalyzer.reader;

import java.io.IOException;

public interface Reader {

    String nextLine() throws IOException;

    void reset() throws IOException;

    void close();

}
