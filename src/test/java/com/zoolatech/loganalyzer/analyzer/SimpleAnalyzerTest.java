package com.zoolatech.loganalyzer.analyzer;

import com.zoolatech.loganalyzer.reader.Reader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SimpleAnalyzerTest {

    private SimpleAnalyzer simpleAnalyzer;

    private Reader reader;

    @BeforeEach
    public void setup() {
        simpleAnalyzer = new SimpleAnalyzer();
        reader = mock(Reader.class);

         /*Setting findMe field to custom value
         (because originally set via @Value)*/
        String lineToBeFoundByAnalyzer = "error";
        org.springframework.test.util.ReflectionTestUtils.setField(simpleAnalyzer, "findMe", lineToBeFoundByAnalyzer);
    }

    @Test
    public void isMatchReturnsTrueIfFindsLine() throws IOException {
        when(reader.nextLine()).thenReturn("log-error-1");
        assertTrue(simpleAnalyzer.isMatch(reader.nextLine()));
    }

    @Test
    public void isMatchReturnsFalseIfDoesNotFindLine() throws IOException {
        when(reader.nextLine()).thenReturn("log-line-1");
        assertFalse(simpleAnalyzer.isMatch(reader.nextLine()));
    }
}