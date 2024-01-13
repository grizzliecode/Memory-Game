package com.example.memorygame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ScoreReaderTest {
    @BeforeEach
    void setUp()
    {
        ScoreReader.writeToFile(Integer.toString(1200));

    }
    @AfterEach
    void cleanUp()
    {
        ScoreReader.writeToFile(Integer.toString(0));
    }
    @Test
    @DisplayName("Value should be grater then 0")
    void verifyReading()
    {
        Assertions.assertThat(Integer.parseInt(ScoreReader.readFromFile())).isGreaterThan(0);
    }

    @Test
    @DisplayName("Value should be 123")
    void verifyWriting()
    {
        ScoreReader.writeToFile("123");
        Assertions.assertThat(ScoreReader.readFromFile()).isEqualTo(new String("123"));
    }

}