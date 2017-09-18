package com.github.qola;

import org.junit.jupiter.api.*;

/*
 * PER_METHOD가 디폴트 이며, PER_CLASS의 경우 하나의 동일한 인스턴스로 테스트가 실행된다
 * -Djunit.jupiter.testinstance.lifecycle.default=per_class (디폴트 lifecycle instance 변경 )
 */
@DisplayName("5. Lifecycle")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PerClassTest {

    //Test Instance 가 PER_CLASS 인 경우  BeforeAll, AfterAll 에 static 선언이 불필요
    @BeforeAll
    void init(){
    }

    @AfterAll
    void tearDown() {
    }

    @Test
    void testAAA(){
        System.out.println("test");
    }
}
