package com.zoolatech.loganalyzer.printer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ConsolePrinterTest {

    ConsolePrinter consolePrinter;

    @BeforeEach
    public void setup() {
        consolePrinter = new ConsolePrinter();
    }

    @Test
    public void printOutputsCorrectLineAndFormatting() {
        String lineReturnedByAnalyzer = "log-error-1";
        String expectedOutput = "line from log: " + lineReturnedByAnalyzer + "\n";
        String actualConsoleOutput;
        PrintStream originalOut = System.out;
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream(100);
            PrintStream capture = new PrintStream(os);
            // From this point on, everything printed to System.out will get captured
            System.setOut(capture);
            consolePrinter.print(lineReturnedByAnalyzer);
            capture.flush();
            actualConsoleOutput = os.toString();
        } finally {
            System.setOut(originalOut);
        }
        assertEquals(expectedOutput, actualConsoleOutput);
    }
}