package com.accountservice.accountservice;


import account.service.FormRegister;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RegisterTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void RestreationTest() throws Exception {

        FormRegister formRegister = new FormRegister();
        formRegister.setEmail("sdffdsfds@mail.ru");
        formRegister.setFirstName("tony");
        formRegister.setSecondName("cor");
        formRegister.setLogin("4");
        formRegister.setPassword("4");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(formRegister);

        this.mockMvc.perform(post("/registration").contentType(MediaType.APPLICATION_JSON).content(json).accept(MediaType.APPLICATION_JSON)).andDo(print());
    }

}
