package com.zoolatech.loganalyzer.reader;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StubReaderTest {

    private StubReader stubReader;

    @BeforeEach
    public void setup() {
        stubReader = new StubReader();
    }

    @Test
    public void stubNextLineReturnsCorrectLine() {
        assertEquals("log-entry-1", stubReader.nextLine());
    }

    @Test
    public void stubNextLineReturnsCorrectLineOnMultipleCalls() {
        stubReader.nextLine();
        assertEquals("log-entry-2", stubReader.nextLine());
    }

    @Test
    public void stubNextLineReturnsNullWhenNoLinesLeft() {
        for (int i = 0; i < 5; i++) {
            stubReader.nextLine();
        }
        assertNull(stubReader.nextLine());
    }

    @Test
    public void stubReaderIsResetOnEachInstantiation() {
        String firstInstanceLine = stubReader.nextLine();
        StubReader stubReader2 = new StubReader();
        String secondInstanceLine = stubReader2.nextLine();
        assertEquals(firstInstanceLine, secondInstanceLine);
    }

    @Test
    public void resetCreatesNewListAndIterator() {
        String firstLineBeforeReset = stubReader.nextLine();
        stubReader.reset();
        String firstLineAfterReset = stubReader.nextLine();
        assertEquals(firstLineBeforeReset, firstLineAfterReset);
    }

}