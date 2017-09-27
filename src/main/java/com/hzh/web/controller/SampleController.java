package com.hzh.web.controller;

import com.hzh.web.event.CustomEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {
    @Autowired
    private CustomEventPublisher publisher;

    @RequestMapping("/home")
    @ResponseBody
    String home() {
        publisher.publish();
        return "Hello World!";
    }


}