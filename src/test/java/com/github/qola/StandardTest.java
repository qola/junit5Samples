package com.github.qola;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * Created by Donny on 2017. 9. 18..
 */
@DisplayName("1. Standard Test")
public class StandardTest {

    //staic 선언 필요
    @BeforeAll
    static void initAll() {
        System.out.println("init for all");
    }

    @BeforeEach
    void init() {
        System.out.println("init for every test");
    }


    // public 접근자 불필요
    @Test
    void failingTest() {
        fail("a failing test");
    }

    @Test
    @Disabled("for demonstration purposes")
    void skippedTest() {
        // not executed
    }

    @Test
    @DisplayName("╯°□°）╯")
    void testWithDisplayNameContainingSpecialCharacters() {
    }

    @Test
    @DisplayName("😱 Emoji 사용")
    void testWithDisplayNameContainingEmoji() {
    }


    @Test
    @DisplayName("한글 테스트네임")
    void testWithDisplayNameContainingHangul() {
    }





    @AfterEach
    void tearDown() {
        System.out.println("tearDown for each test");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("tearDown for all");
    }
}
