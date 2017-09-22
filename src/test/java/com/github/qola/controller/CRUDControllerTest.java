package com.github.qola.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Donny on 2017. 9. 15..
 */
@ActiveProfiles("test")
@DisplayName("14. SpringBoot Integration Test")
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CRUDControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @DisplayName("create")
    @Test
    public void create() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("/create", String.class);
        assertEquals(responseEntity.getStatusCode().value(), 200);
        assertEquals(responseEntity.getBody(), "created");
    }

    @Test
    void read() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("/read", String.class);
        assertEquals(responseEntity.getStatusCode().value(), 200);
        assertEquals(responseEntity.getBody(), "read");
    }

    @Test
    void update() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("/update", String.class);
        assertEquals(responseEntity.getStatusCode().value(), 200);
        assertEquals(responseEntity.getBody(), "update");
    }

    @Test
    void delete() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("/delete", String.class);
        assertEquals(responseEntity.getStatusCode().value(), 200);
        assertEquals(responseEntity.getBody(), "deleted");
    }

}