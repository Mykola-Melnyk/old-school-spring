package com.zoolatech.loganalyzer.reader;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class StubReader implements Reader {

    private Iterator<String> iterator;

    public StubReader() {
        List<String> lines = new ArrayList<>();
        lines.add("log-entry-1");
        lines.add("log-entry-2");
        lines.add("log-error-1");
        lines.add("log-entry-3");
        lines.add("log-error-2");
        iterator = lines.iterator();
    }

    @Override
    public String nextLine() {
        if (iterator.hasNext()) {
            return iterator.next();
        }
        return null;
    }

}
