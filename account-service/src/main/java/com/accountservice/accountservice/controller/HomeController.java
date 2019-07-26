package com.accountservice.accountservice.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {


    @RequestMapping("/hello")
    public ResponseEntity hello() {
        return ResponseEntity.ok(new Employee());
    }

    @RequestMapping("/secure")
    public String secure() {
        return "this is SECURE";
    }

}
