package com.github.qola.controller;

import com.github.qola.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Donny on 2017. 9. 15..
 */
@RestController
public class HelloController {
    @Autowired
    private HelloService helloService;

    @RequestMapping(value="/hello")
    public String hello(){
        String name = helloService.getName();
        String message =  "hello "+ name;

        System.out.println(message);
        return message;
    }
}
