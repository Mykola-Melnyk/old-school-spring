package com.zoolatech.loganalyzer.printer;

import org.springframework.stereotype.Component;

@Component
public class ConsolePrinter implements Printer {

    @Override
    public void print(String line) {
        System.out.printf("line from log: %s%n", line);
    }

}
