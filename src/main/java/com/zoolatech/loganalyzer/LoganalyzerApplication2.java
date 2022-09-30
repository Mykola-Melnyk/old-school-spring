package com.zoolatech.loganalyzer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LoganalyzerApplication2 {


    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        LogAnalyzer logAnalyzer = (LogAnalyzer) appContext.getBean("LogAnalyzer");
        logAnalyzer.startAnalysis();
    }

}
