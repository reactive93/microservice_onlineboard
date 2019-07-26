package com.accountservice.accountservice.components;


import account.service.FormRegister;

import account.service.dao.User;
import account.service.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class RegisterService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder encoder;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Autowired
    public void setEncoder(BCryptPasswordEncoder encoder) {
        this.encoder = encoder;
    }

    public boolean create(FormRegister formRegister) {

        User user = userRepository.getUserByLogin(formRegister.getLogin());
        if (user == null) {
            User newUser = new User();
            newUser.setLogin(formRegister.getLogin());
            newUser.setPassword(encoder.encode(formRegister.getPassword()));
            newUser.setEmail(formRegister.getEmail());
            newUser.setCreatedAt(new Date());
            newUser.setActive(true);
            this.userRepository.save(newUser);
            return true;
        }
        return false;
    }

}
