package com.zuulservice.zuulservice.components;

import io.jsonwebtoken.Jwts;

import java.util.Date;

public class JWTChecker {
    static final long EXPIRATIONTIME = 5_000;

    static final String SECRET = "ThisIsASecret";

    static final String TOKEN_PREFIX = "Bearer";

    static final String HEADER_STRING = "Authorization";



    public static String check(String token) {
        String login = null;
        try {
            login = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody().getSubject();


        }catch (Exception e) {

        }
        return login;
    }

}
