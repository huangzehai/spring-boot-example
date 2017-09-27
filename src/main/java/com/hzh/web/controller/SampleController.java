package com.hzh.web.controller;

import com.hzh.web.event.CustomEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {
    @Autowired
    private CustomEventPublisher publisher;

    @RequestMapping("/home")
    @ResponseBody
    String home(@RequestParam(required = false) String username) {
        publisher.publish();
        String message;
        if (username == null) {
            message = "Hello world!";
        } else {
            message = String.format("Hello %s!", username);
        }
        return message;
    }


}