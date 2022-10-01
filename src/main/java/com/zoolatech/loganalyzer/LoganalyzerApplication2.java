package com.zoolatech.loganalyzer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileNotFoundException;

public class LoganalyzerApplication2 {


    public static void main(String[] args) throws FileNotFoundException {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        LogAnalyzer logAnalyzer = (LogAnalyzer) appContext.getBean("logAnalyzer");
        logAnalyzer.startAnalysis();
    }

}
