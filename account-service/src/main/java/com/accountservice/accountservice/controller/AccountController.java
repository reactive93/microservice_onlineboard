package com.accountservice.accountservice.controller;



import account.service.FormRegister;
import com.accountservice.accountservice.components.LoginService;
import com.accountservice.accountservice.components.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {


    private LoginService loginService;

    private RegisterService registerService;

    @Autowired
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    @Autowired
    public void setRegisterService(RegisterService registerService) {
        this.registerService = registerService;
    }

    @RequestMapping(value = "/login1",method = RequestMethod.POST)
    public ResponseEntity<String> getTokenOnLogin(@RequestParam("login") String login, @RequestParam("password") String password) {

        String token = loginService.getToken(login, password);
        if (token.length()>0) {
            return ResponseEntity.ok("Bearer " + token);
        }
        else {
            return ResponseEntity.status(401).body("bad credentials");
        }
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST, produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity register(@RequestBody FormRegister formRegister) {
        System.out.println(formRegister);
        if (registerService.create(formRegister)) {
            return ResponseEntity.ok("OK");
        }
        return ResponseEntity.ok("Error. This login already in use");
    }
}
