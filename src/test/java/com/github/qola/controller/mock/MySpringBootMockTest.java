package com.github.qola.controller.mock;

import com.github.qola.service.HelloService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Donny on 2017. 9. 19..
 */
@SpringBootMockTest
@DisplayName("13. SpringBoot Mock Test with Custom Annotation")
public class MySpringBootMockTest {
    @MockBean HelloService helloService;

    @Test
    void myTest(@Autowired MockMvc mockMvc) throws Exception {
        when(helloService.getName()).thenReturn("DONNY.00");
        mockMvc.perform(get("/hello"))
            //    .andExpect(view().name(""))
            //    .andExpect(model().attribute("events", hasSize(greaterThan(10))));
            .andExpect(status().isOk());
    }
}
