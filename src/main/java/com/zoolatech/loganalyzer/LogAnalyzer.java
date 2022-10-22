package com.zoolatech.loganalyzer;

import com.zoolatech.loganalyzer.analyzer.Analyzer;
import com.zoolatech.loganalyzer.printer.Printer;
import com.zoolatech.loganalyzer.reader.Reader;

import java.io.FileNotFoundException;
import java.io.IOException;

public class LogAnalyzer {

    private Reader reader;
    private Analyzer analyzer;
    private Printer printer;

    public LogAnalyzer(Reader reader, Analyzer analyzer, Printer printer) {
        this.reader = reader;
        this.analyzer = analyzer;
        this.printer = printer;
    }

    public void startAnalysis() throws IOException {
        String line;
        while ((line = reader.nextLine()) != null) {
            if (analyzer.isMatch(line)) {
                printer.print(line);
            }
        }
        reader.close();
    }

    public String startWebAnalysis() throws IOException {
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = reader.nextLine()) != null) {
            if (analyzer.isMatch(line)) {
                printer.print(line);
                sb.append(line);
                sb.append("<br>");
            }
        }
        return sb.toString();
    }

}
