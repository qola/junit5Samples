package com.github.qola.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Donny on 2017. 9. 15..
 */
@RestController
public class HelloController {
    @RequestMapping(value="/hello")
    public String hello(){
        return "hello world";
    }
}
