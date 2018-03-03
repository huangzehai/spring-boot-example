package com.hzh.web.controller;

import com.hzh.web.model.Event;
import com.hzh.web.model.User;
import com.hzh.web.service.EventService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("event")
public class EventController {
    @Autowired
    private EventService eventService;

    @RequestMapping("add")
    @ResponseBody
    String addEvent(String username, String eventTitle) {
        if (StringUtils.isBlank(username)) {
            return "username should not be blank";
        }
        User user = new User();
        user.setUsername(username);
        Event event = new Event();
        event.setEventTitle(eventTitle);
        eventService.addEvent(event, user);
        return "Add event: " + eventTitle;
    }

}
