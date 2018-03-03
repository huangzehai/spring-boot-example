package com.hzh.web.service;

import com.hzh.web.model.Event;
import com.hzh.web.model.User;

public interface EventService {
    int addEvent(Event event,User user);
}
