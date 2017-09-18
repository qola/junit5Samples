package com.github.qola;

import com.github.qola.domain.Person;
import com.github.qola.extension.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static java.time.Duration.ofMillis;
import static java.time.Duration.ofMinutes;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * Created by Donny on 2017. 9. 18..
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("2. Assertions Test")
public class AssertionsTest {
    @Mock
    private Person person;

    @BeforeEach
    void init() {
        when(person.getFirstName()).thenReturn("Donny");
        when(person.getLastName()).thenReturn("00");
    }

    @Test
    void standardAssertions() {
        assertEquals(2, 2);
        assertEquals(4, 4, "optional assertion message는 마지막 파라메터에 추가");
        assertTrue(2 == 1, () -> "Supplier<String> 를 사용해 메시지 초기화를 늦춤 " + countSum());
    }

    @Test
    void groupedAssertions() {
        assertAll("person assertion",
                () -> assertEquals("Donny", person.getFirstName()),
                () -> assertEquals("01", person.getLastName())
        );
    }

    @Test
    void dependentAssertions() {
        assertAll("properties",
                () -> {
                    String firstName = person.getFirstName();
                    assertNotNull(firstName);

                    // Executed only if the previous assertion is valid.
                    assertAll("first name",
                            () -> assertTrue(firstName.startsWith("D")),
                            () -> assertTrue(firstName.endsWith("y"))
                    );
                },
                () -> {
                    String lastName = person.getLastName();
                    assertNotNull(lastName);

                    assertAll("last name",
                            () -> assertTrue(lastName.startsWith("0")),
                            () -> assertTrue(lastName.endsWith("0"))
                    );
                }
        );
    }

    @Test
    void exceptionTesting() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("a message");
        });
        assertEquals("a message", exception.getMessage());
    }


    @Test
    void timeoutNotExceeded() {
        assertTimeout(ofMinutes(2), () -> {
            System.out.println("timeoutNotExceeded");
        });
    }

    @Test
    void timeoutNotExceededWithResult() {
        // The following assertion succeeds, and returns the supplied object.
        String actualResult = assertTimeout(ofMinutes(2), () -> {
            Thread.sleep(2500L);
            return "a result";
        });
        assertEquals("a result", actualResult);
    }

    @Test
    void timeoutNotExceededWithMethod() {
        // The following assertion invokes a method reference and returns an object.
        String actualGreeting = assertTimeout(ofMinutes(2), AssertionsTest::greeting);
        assertEquals("hello world!", actualGreeting);
    }

    @DisplayName("execution exceeded timeout of 10 ms by 91 ms")
    @Test
    void timeoutExceeded() {
        assertTimeout(ofMillis(10), () -> {
            Thread.sleep(100);
        });
    }

    @DisplayName("execution timed out after 10 ms")
    @Test
    void timeoutExceededWithPreemptiveTermination() {
        assertTimeoutPreemptively(ofMillis(10), () -> {
            Thread.sleep(10000000);
        });
    }


    private int countSum() {
        System.out.println("calculating ... ");
        return 1000000;
    }

    private static String greeting() {
        return "hello world!";
    }

}
