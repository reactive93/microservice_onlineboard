package com.websocket.websocketservice.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;


@Controller
public class GroupController {

     Logger logger = LoggerFactory.getLogger(GroupController.class);

    @MessageMapping("/event")
    @SendTo("/topic/lol")
    public String group(String message) {
        logger.info("WEBSOCKET MESSAGE:", message);
        return message;
    }
}
