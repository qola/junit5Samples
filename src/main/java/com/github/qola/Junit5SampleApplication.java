package com.github.qola;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Donny on 2017. 9. 15..
 */
@SpringBootApplication(scanBasePackages = "com.github.qola")
public class Junit5SampleApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Junit5SampleApplication.class);
        app.run(args);
    }
}
