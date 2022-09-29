package com.zoolatech.loganalyzer;

import com.zoolatech.loganalyzer.analyzer.Analyzer;
import com.zoolatech.loganalyzer.printer.Printer;
import com.zoolatech.loganalyzer.reader.Reader;

public class LogAnalyzer {

    private Reader reader;
    private Analyzer analyzer;
    private Printer printer;

    public LogAnalyzer(Reader reader, Analyzer analyzer, Printer printer) {
        this.reader = reader;
        this.analyzer = analyzer;
        this.printer = printer;
    }

    public void startAnalysis() {
        String line;
        while ((line = reader.nextLine()) != null) {
            if (analyzer.isMatch(line)) {
                printer.print(line);
            }
        }
    }

}
