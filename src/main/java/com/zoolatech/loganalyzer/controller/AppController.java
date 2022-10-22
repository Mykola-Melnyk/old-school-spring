package com.zoolatech.loganalyzer.controller;

import com.zoolatech.loganalyzer.LogAnalyzer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class AppController {

    private LogAnalyzer logAnalyzer;

    public AppController(LogAnalyzer logAnalyzer) {
        this.logAnalyzer = logAnalyzer;
    }
    @RequestMapping("/log_analyzer")
    public String startLogWeb(Model model) throws IOException {
        String logLines = logAnalyzer.startWebAnalysis();

        String prefix = "log";

        model.addAttribute(prefix + "Lines", logLines);
        return "logPage";
    }


}
