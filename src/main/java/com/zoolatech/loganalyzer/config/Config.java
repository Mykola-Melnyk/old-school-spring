package com.zoolatech.loganalyzer.config;

import com.zoolatech.loganalyzer.LogAnalyzer;
import com.zoolatech.loganalyzer.analyzer.Analyzer;
import com.zoolatech.loganalyzer.analyzer.SimpleAnalyzer;
import com.zoolatech.loganalyzer.printer.ConsolePrinter;
import com.zoolatech.loganalyzer.printer.Printer;
import com.zoolatech.loganalyzer.reader.Reader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Analyzer getAnalyzer(@Value("${analyzer.pattern}") String pattern) {
        return new SimpleAnalyzer(pattern);
    }

    @Bean
    public Printer getPrinter() {
        return new ConsolePrinter();
    }

    @Bean
    public LogAnalyzer getLogAnalyzer(Reader reader, Analyzer analyzer, Printer printer) {
        return new LogAnalyzer(reader, analyzer, printer);
    }

}
