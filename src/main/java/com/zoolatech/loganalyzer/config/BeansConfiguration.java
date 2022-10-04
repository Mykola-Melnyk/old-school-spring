package com.zoolatech.loganalyzer.config;

import com.zoolatech.loganalyzer.LogAnalyzer;
import com.zoolatech.loganalyzer.analyzer.SimpleAnalyzer;
import com.zoolatech.loganalyzer.printer.ConsolePrinter;
import com.zoolatech.loganalyzer.reader.FileReader;
import com.zoolatech.loganalyzer.reader.StubReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfiguration {
    @Bean
    public FileReader fileReader() {
        return new FileReader("/log.txt");
    }

    @Bean
    public StubReader stubReader() {
        return new StubReader();
    }

    @Bean
    public SimpleAnalyzer simpleAnalyzer() {
        return new SimpleAnalyzer("error");
    }

    @Bean
    public ConsolePrinter consolePrinter() {
        return new ConsolePrinter();
    }

    @Bean
    public LogAnalyzer logAnalyzer() {
        return new LogAnalyzer(fileReader(), simpleAnalyzer(), consolePrinter());
    }
}
