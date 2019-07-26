package com.zuulservice.zuulservice.filters;

import account.service.dao.User;
import com.zuulservice.zuulservice.components.CustomUserDetail;
import com.zuulservice.zuulservice.components.JWTChecker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class JWTFilter extends OncePerRequestFilter {

    private final Logger logger = LoggerFactory.getLogger(JWTFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        String token = httpServletRequest.getHeader("Authorization");
        logger.info("token " + token);
        logger.info("METHOD " + httpServletRequest.getMethod());
        logger.info(httpServletRequest.getRequestURI());
        if (token != null) {
            String clearToken = token.split(" ")[1];
            String login = JWTChecker.check(clearToken);
            if(login!= null) {
                User user = new User();
                user.setLogin(login);
                SecurityContextHolder.getContext().
                        setAuthentication(new UsernamePasswordAuthenticationToken(new CustomUserDetail(user),null, Collections.singleton(new SimpleGrantedAuthority("USER"))));
                filterChain.doFilter(httpServletRequest, httpServletResponse);
            }

        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);

    }
}
