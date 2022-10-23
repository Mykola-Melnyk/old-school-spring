package com.zoolatech.loganalyzer.loganalyzers;

import com.zoolatech.loganalyzer.analyzer.Analyzer;
import com.zoolatech.loganalyzer.printer.Printer;
import com.zoolatech.loganalyzer.reader.Reader;

import java.io.IOException;

public class ConsoleLogAnalyzer implements GenericLogAnalyzer{

    private final Reader reader;
    private final Analyzer analyzer;
    private final Printer printer;

    public ConsoleLogAnalyzer(Reader reader, Analyzer analyzer, Printer printer) {
        this.reader = reader;
        this.analyzer = analyzer;
        this.printer = printer;
    }
    @Override
    public String startAnalysis() throws IOException {
        reader.reset();
        String line;
        while ((line = reader.nextLine()) != null) {
            if (analyzer.isMatch(line)) {
                printer.print(line);
            }
        }
        reader.close();
        return null;
    }
}
