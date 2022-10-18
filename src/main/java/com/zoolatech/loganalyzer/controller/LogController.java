package com.zoolatech.loganalyzer.controller;

import com.zoolatech.loganalyzer.LogAnalyzer;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogController extends AbstractController {

    private LogAnalyzer logAnalyzer;

    public void setLogAnalyzer(LogAnalyzer logAnalyzer) {
        this.logAnalyzer = logAnalyzer;
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String logLines = logAnalyzer.startWebAnalysis();
        return new ModelAndView("controller", "logLines", logLines);
    }
}