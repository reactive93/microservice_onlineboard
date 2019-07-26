package com.accountservice.accountservice.components;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;


public class JWTCreator {
    static final long EXPIRATIONTIME = 3_600_000;

    static final String SECRET = "ThisIsASecret";

    static final String TOKEN_PREFIX = "Bearer";

    static final String HEADER_STRING = "Authorization";


    public static String create(String login) {
        String token = Jwts.builder().setSubject(login).setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                .signWith(SignatureAlgorithm.HS512, SECRET).compact();
        return token;
    }

    public static boolean check(String token) {
        boolean checker = false;
        try {
            Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody().getSubject();
            checker = true;
        }catch (Exception e) {

        }
        return checker;
    }

}
