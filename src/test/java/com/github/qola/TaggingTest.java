package com.github.qola;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * Created by Donny on 2017. 9. 18..
 */
@Tag("fast")
@Tag("model")
@DisplayName("4. Tagging Test")
public class TaggingTest {

    @Test
    @Tag("taxes")
    void testingTaxCalculation() {
        System.out.println("tagging test");
    }
}
