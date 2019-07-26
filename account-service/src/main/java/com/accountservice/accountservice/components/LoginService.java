package com.accountservice.accountservice.components;


import account.service.dao.User;
import account.service.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class LoginService {

    private BCryptPasswordEncoder encoder;
    private UserRepository userRepository;

    @Autowired()
    public void setEncoder(BCryptPasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public String getToken(String login, String password) {
        User user = userRepository.getUserByLogin(login);
        String token = "";
        if (user != null) {
            if (encoder.matches(password, user.getPassword())) {
                token = JWTCreator.create(login);
                return token;
            }
        }
        return "";
    }

}
