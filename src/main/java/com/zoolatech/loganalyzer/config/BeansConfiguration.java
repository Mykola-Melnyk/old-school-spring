package com.zoolatech.loganalyzer.config;

import com.zoolatech.loganalyzer.LogAnalyzer;
import com.zoolatech.loganalyzer.analyzer.Analyzer;
import com.zoolatech.loganalyzer.analyzer.SimpleAnalyzer;
import com.zoolatech.loganalyzer.controller.AppController;
import com.zoolatech.loganalyzer.printer.ConsolePrinter;
import com.zoolatech.loganalyzer.printer.Printer;
import com.zoolatech.loganalyzer.reader.CustomSysPropReaderFactory;
import com.zoolatech.loganalyzer.reader.FileReader;
import com.zoolatech.loganalyzer.reader.Reader;
import com.zoolatech.loganalyzer.reader.ReaderFactory;
import com.zoolatech.loganalyzer.reader.S3Reader;
import com.zoolatech.loganalyzer.reader.StubReader;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class BeansConfiguration {

    @Bean
    public FactoryBean<Reader> customSysPropReaderFactory() {
        return new CustomSysPropReaderFactory();
    }

    @Bean
    public Analyzer simpleAnalyzer() {
        return new SimpleAnalyzer();
    }

    @Bean
    public Printer consolePrinter() {
        return new ConsolePrinter();
    }


    @Bean
    public LogAnalyzer logAnalyzer(Reader reader, Analyzer analyzer, Printer printer) {
        return new LogAnalyzer(reader, analyzer, printer);
    }

    @Bean
    public AppController appController(LogAnalyzer logAnalyzer) {
        return new AppController (logAnalyzer);
    }
}
