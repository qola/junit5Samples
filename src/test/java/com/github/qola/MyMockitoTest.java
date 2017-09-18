package com.github.qola;

import com.github.qola.domain.Person;
import com.github.qola.extension.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by Donny on 2017. 9. 18..
 */
@DisplayName("10. Mockito Test")
@ExtendWith(MockitoExtension.class)
public class MyMockitoTest {

    // ParameterResolver Extension
    // 필드 레벨과 메소드 파라메터 레벨에서 dependency injection support (via Mockito 2.x)
    @BeforeEach
    void init(@Mock Person person) {
        when(person.getName()).thenReturn("Donny.00");
    }

    @Test
    void simpleTestWithInjectedMock(@Mock Person person) {
        assertEquals("Donny.00", person.getName());
    }
}
