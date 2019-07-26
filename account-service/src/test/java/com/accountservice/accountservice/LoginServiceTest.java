package com.accountservice.accountservice;


import com.accountservice.accountservice.components.LoginService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginServiceTest {

    private LoginService loginService;

    @Autowired
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    @Test
    public void getTokenTest() {
        String token = loginService.getToken("3","3");
        System.out.println(token);
        Assert.assertTrue("Token above 0", token.length()>0);

    }
}
