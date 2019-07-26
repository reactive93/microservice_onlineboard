package com.edgeservice.edgeservice.controller.account;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountApi {


    private IAccountClient accountClient;

    @Autowired
    AccountApi(IAccountClient accountClient) {
        this.accountClient = accountClient;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseEntity<String> getTokenOnLogin(@RequestParam("login") String login, @RequestParam("password") String password) {
        return this.accountClient.getTokenOnLogin(login, password);
    }
}
