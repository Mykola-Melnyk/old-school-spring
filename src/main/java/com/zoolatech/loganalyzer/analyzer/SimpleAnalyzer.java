package com.zoolatech.loganalyzer.analyzer;

import org.springframework.beans.factory.annotation.Value;

public class SimpleAnalyzer implements Analyzer {

    @Value("${find.me}")
    private String findMe;

//    public SimpleAnalyzer(String findMe) {
//        this.findMe = findMe;
//    }

    @Override
    public boolean isMatch(String line) {
        return line.contains(findMe);
    }

}
