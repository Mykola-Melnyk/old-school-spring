package com.zoolatech.loganalyzer.config;

import com.zoolatech.loganalyzer.LogAnalyzer;
import com.zoolatech.loganalyzer.analyzer.Analyzer;
import com.zoolatech.loganalyzer.analyzer.SimpleAnalyzer;
import com.zoolatech.loganalyzer.printer.ConsolePrinter;
import com.zoolatech.loganalyzer.printer.Printer;
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
    public FactoryBean<Reader> readerFactory() {
        ReaderFactory readerFactory = new ReaderFactory();
        readerFactory.setType("s3");
        readerFactory.setFileName("log.txt");
        return readerFactory;
    }

    @Bean
    public Analyzer simpleAnalyzer() {
        return new SimpleAnalyzer("error");
    }

    @Bean
    public Printer consolePrinter() {
        return new ConsolePrinter();
    }


    @Bean
    public LogAnalyzer logAnalyzer(Reader reader, Analyzer analyzer, Printer printer) {
        return new LogAnalyzer(reader, analyzer, printer);
    }
    //    @Bean("s3Reader")
//    public Reader s3Reader() throws IOException {
//        return new S3Reader("log.txt");
//    }
//    @Bean("fileReader")
//    public Reader fileReader() throws IOException {
//        return new FileReader("/log.txt");
//    }
//
//    @Bean("stubReader")
//    public Reader stubReader() {
//        return new StubReader();
//    }
    //    @Bean
//    public LogAnalyzer logAnalyzer(@Qualifier("s3Reader") Reader reader, Analyzer analyzer, Printer printer) {
//        return new LogAnalyzer(reader, analyzer, printer);
//    }
}
