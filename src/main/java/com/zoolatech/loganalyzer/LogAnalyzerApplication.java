package com.zoolatech.loganalyzer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class LogAnalyzerApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(LogAnalyzerApplication.class, args);
    }
}

