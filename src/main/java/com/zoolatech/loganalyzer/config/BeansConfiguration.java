package com.zoolatech.loganalyzer.config;

import com.zoolatech.loganalyzer.analyzer.Analyzer;
import com.zoolatech.loganalyzer.analyzer.SimpleAnalyzer;
import com.zoolatech.loganalyzer.loganalyzers.LogAnalyzer;
import com.zoolatech.loganalyzer.loganalyzers.WebLogAnalyzer;
import com.zoolatech.loganalyzer.printer.ConsolePrinter;
import com.zoolatech.loganalyzer.printer.Printer;
import com.zoolatech.loganalyzer.reader.CustomSysPropReaderFactory;
import com.zoolatech.loganalyzer.reader.Reader;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
        return new WebLogAnalyzer(reader, analyzer, printer);
    }

}
