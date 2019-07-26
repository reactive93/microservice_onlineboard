package com.edgeservice.edgeservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiGateway {

    private IClient client;

    @Autowired
    public ApiGateway (IClient client) {
        this.client = client;
    }

    @RequestMapping("/hello")
    ResponseEntity hello() {
        ResponseEntity resp = this.client.hello();
        return resp;
    }

    @RequestMapping("/secure")
    public String secure() {
        return this.client.secure();
    }
}
