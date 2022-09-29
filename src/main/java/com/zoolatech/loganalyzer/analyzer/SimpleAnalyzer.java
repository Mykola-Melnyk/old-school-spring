package com.zoolatech.loganalyzer.analyzer;

public class SimpleAnalyzer implements Analyzer {

    private String findMe;

    public SimpleAnalyzer(String findMe) {
        this.findMe = findMe;
    }

    @Override
    public boolean isMatch(String line) {
        return line.contains(findMe);
    }

}
