package com.fastcampus.javaallinone.project3.mycontact.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RunAs;


@RestController
public class HelloWorldController {
    @GetMapping(value="/api/helloWorld")
    public String helloWorld(){
        return "Hello World";
    }


}
