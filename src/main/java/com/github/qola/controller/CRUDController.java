package com.github.qola.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Donny on 2017. 9. 15..
 */
@RestController
public class CRUDController {
    @RequestMapping(value="/create")
    public String create(){
        return "created";
    }

    @RequestMapping(value="/read")
    public String read(){
        return "read";
    }

    @RequestMapping(value="/update")
    public String update(){
        return "update";
    }

    @RequestMapping(value="/delete")
    public String delete(){
        return "deleted";
    }
}
