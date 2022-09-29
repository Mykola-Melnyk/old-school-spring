package com.zoolatech.loganalyzer.printer;

public class ConsolePrinter implements Printer {

    @Override
    public void print(String line) {
        System.out.printf("line from log: %s%n", line);
    }

}
