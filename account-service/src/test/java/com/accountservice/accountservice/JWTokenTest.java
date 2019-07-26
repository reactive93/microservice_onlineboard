package com.accountservice.accountservice;

import com.accountservice.accountservice.components.JWTCreator;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class JWTokenTest {



    @Test
    public void jwtTest() throws InterruptedException {
        String token = JWTCreator.create("3");
        Thread.sleep(4000);
        boolean check = JWTCreator.check(token);
        System.out.println(check);
    }

    @Test
    public void encodePassword() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodePass = encoder.encode("2");
        System.out.println(encodePass);
    }
}
