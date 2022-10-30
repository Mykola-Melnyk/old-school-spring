package com.zoolatech.loganalyzer;

import com.zoolatech.loganalyzer.config.BeansConfiguration;
import com.zoolatech.loganalyzer.loganalyzers.LogAnalyzer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.io.IOException;

public class LogAnalyzerApplication {
    public static void main(String[] args) throws IOException {
        ApplicationContext appContext = new AnnotationConfigApplicationContext(BeansConfiguration.class);
        LogAnalyzer logAnalyzer = (LogAnalyzer) appContext.getBean("logAnalyzer");
        logAnalyzer.startAnalysis();
    }
}