package com.accountservice.accountservice.controller;

import java.io.Serializable;

public class Employee implements Serializable {

    private String name = "dodick";
    private String secondName = "fucker";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
}
