package com.github.qola.interfaceanddefaultmethod;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Donny on 2017. 9. 18..
 */
@ActiveProfiles("test")
@DisplayName("11. InterfaceDefaultMethod Test")
public class InterfaceDefaultMethodTest implements TestLifecycleLogger, TimeExecutionLogger, TestInterfaceDynamicTests {

    @Test
    void isEqualValue() {
        assertEquals(1, 1, "is always equal");
    }
}
