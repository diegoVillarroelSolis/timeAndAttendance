package com.husky.controllers;

import com.husky.entities.Message;
import com.husky.entities.Notification;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class NotificationController {


    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Notification greeting(Message message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Notification("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

}
