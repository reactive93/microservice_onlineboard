package com.edgeservice.edgeservice.controller;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
//,url = "http://${server.address}:${server.port}"
@FeignClient(name = "ACCOUNT-SERVICE")
public interface IClient {

    @RequestMapping("/hello")
    ResponseEntity hello();

    @RequestMapping("/secure")
    public String secure();
}
