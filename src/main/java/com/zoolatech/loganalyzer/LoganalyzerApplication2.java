package com.zoolatech.loganalyzer;

import com.zoolatech.loganalyzer.config.BeansConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LoganalyzerApplication2 {

    public static void main(String[] args) throws IOException {
        ApplicationContext appContext = new AnnotationConfigApplicationContext(BeansConfiguration.class);
        LogAnalyzer logAnalyzer = (LogAnalyzer) appContext.getBean("logAnalyzer");
        System.out.println("1st run");
        logAnalyzer.startAnalysis();
        System.out.println("2nd run");
        logAnalyzer.startAnalysis();
        System.out.println("done");
    }
}
