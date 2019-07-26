package com.edgeservice.edgeservice.controller.account;

import account.service.FormRegister;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ACCOUNT-SERVICE")
public interface IAccountClient {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<String> getTokenOnLogin(@RequestParam("login") String login, @RequestParam("password") String password);

    @RequestMapping(value = "/registration", method = RequestMethod.POST, produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity register(@RequestBody FormRegister formRegister);
}
