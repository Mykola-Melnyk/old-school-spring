package com.zoolatech.loganalyzer.loganalyzers;

import com.zoolatech.loganalyzer.analyzer.Analyzer;
import com.zoolatech.loganalyzer.analyzer.SimpleAnalyzer;
import com.zoolatech.loganalyzer.printer.ConsolePrinter;
import com.zoolatech.loganalyzer.printer.Printer;
import com.zoolatech.loganalyzer.reader.Reader;
import com.zoolatech.loganalyzer.reader.StubReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ConsoleLogAnalyzerTest {


    private ConsoleLogAnalyzer logAnalyzer;

    @BeforeEach
    public void setup() throws IOException {
        Reader reader = new StubReader();
        Printer printer = new ConsolePrinter();
        Analyzer analyzer = new SimpleAnalyzer();
        /*Setting findMe field to custom value
         (because originally set via @Value)*/
        String lineToBeFoundByAnalyzer = "error";
        org.springframework.test.util.ReflectionTestUtils.setField(analyzer, "findMe", lineToBeFoundByAnalyzer);
        logAnalyzer = new ConsoleLogAnalyzer(reader, analyzer, printer);
    }

    @Test
    public void startAnalysisOutputsCorrectString() throws IOException {
        String actualLogAnalyzerConsoleOutput;
        PrintStream originalOut = System.out;
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream(100);
            PrintStream capture = new PrintStream(os);
            // From this point on, everything printed to System.out will get captured
            System.setOut(capture);
            logAnalyzer.startAnalysis();
            capture.flush();
            actualLogAnalyzerConsoleOutput = os.toString();
        } finally {
            System.setOut(originalOut);
        }
        String expectedResult = "line from log: " + "log-error-1" + "\n" + "line from log: " + "log-error-2" + "\n";
        assertEquals(expectedResult, actualLogAnalyzerConsoleOutput);
    }
}