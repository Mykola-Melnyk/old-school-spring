package com.zoolatech.loganalyzer;

import com.zoolatech.loganalyzer.config.BeansConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.io.IOException;

@SpringBootApplication
public class LoganalyzerApplication2 {

    public static void main(String[] args) throws IOException {
            SpringApplication.run(LoganalyzerApplication2.class, args);
        }
    }

