package com.zoolatech.loganalyzer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoganalyzerApplication implements CommandLineRunner {

    private final LogAnalyzer logAnalyzer;

    public LoganalyzerApplication(LogAnalyzer logAnalyzer) {
        this.logAnalyzer = logAnalyzer;
    }

    public static void main(String[] args) {
        SpringApplication.run(LoganalyzerApplication.class, args);
    }

    @Override
    public void run(String... args) {
        logAnalyzer.startAnalysis();
    }

}
