package com.github.qola;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Donny on 2017. 9. 18..
 */
@DisplayName("8. Repeated Test")
public class MyRepeatedTest {
    @BeforeEach
    void beforeEach(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println(String.format("About to execute repetition %d of %d for %s",
                repetitionInfo.getCurrentRepetition(),
                repetitionInfo.getTotalRepetitions(),
                testInfo.getTestMethod().get().getName()));
    }

    @RepeatedTest(10)
    void repeatedTest() {
        System.out.println("repeated test");
    }

    @RepeatedTest(5)
    void repeatedTestWithRepetitionInfo(RepetitionInfo repetitionInfo) {
        System.out.println("repeatedTestWithRepetitionInfo");
        assertEquals(5, repetitionInfo.getTotalRepetitions());
    }

    @RepeatedTest(value = 1, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("Repeat!")
    void customDisplayName(TestInfo testInfo) {
        System.out.printf("customDisplayName");
        assertEquals(testInfo.getDisplayName(), "Repeat! 1/1");
    }

    @RepeatedTest(value = 1, name = RepeatedTest.LONG_DISPLAY_NAME)
    @DisplayName("Details...")
    void customDisplayNameWithLongPattern(TestInfo testInfo) {
        assertEquals(testInfo.getDisplayName(), "Details... :: repetition 1 of 1");
    }

    @RepeatedTest(value = 5, name = "Wiederholung {currentRepetition} von {totalRepetitions}")
    void repeatedTestInGerman() {
        // ...
    }
}
