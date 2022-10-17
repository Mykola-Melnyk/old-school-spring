package com.zoolatech.loganalyzer;

import com.zoolatech.loganalyzer.config.BeansConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileNotFoundException;
import java.io.IOException;

public class LoganalyzerApplication2 {

    public static void main(String[] args) throws IOException {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

//        ApplicationContext appContext = new AnnotationConfigApplicationContext(BeansConfiguration.class);
        LogAnalyzer logAnalyzer = (LogAnalyzer) appContext.getBean("logAnalyzer");
        logAnalyzer.startAnalysis();
    }
}
