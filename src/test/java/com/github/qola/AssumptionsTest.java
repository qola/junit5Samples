package com.github.qola;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

/**
 * Created by Donny on 2017. 9. 18..
 */
@DisplayName("3. Assumptions Test")
public class AssumptionsTest {

    @Test
    void testOnlyOnCiServer() {
        assumeTrue("CI".equals(System.getenv("ENV")));
        System.out.println("CI가 아닐때는 Test를 수행하지 않음");
    }

    @Test
    void testOnlyOnDeveloperWorkstation() {
        assumeTrue("DEV".equals(System.getenv("ENV")),
                () -> "Aborting test: not on developer workstation");

        System.out.println("assumeTrue() 이후로 실행되지 않는다");
    }

    @Test
    void testInAllEnvironments() {
        assumingThat("CI".equals(System.getenv("ENV")),
                () -> {
                    // perform these assertions only on the CI server
                    assertEquals(2, 2);
                });

        // perform these assertions in all environments
        assertEquals("a string", "a string");
        System.out.println("모든 환경에서 테스트가 수행 된다. ");
    }

}
