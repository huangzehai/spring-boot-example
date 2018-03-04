package com.hzh.web.service;

import com.hzh.web.Exception.NetworkException;
import com.hzh.web.mapper.EventMapper;
import com.hzh.web.model.Event;
import com.hzh.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventMapper eventMapper;
    @Autowired
    private UserService userService;

    @Override
    @Transactional(rollbackFor = NetworkException.class)
    public int addEvent(Event event, User user) throws NetworkException {
        eventMapper.addEvent(event);
        userService.addUser(user);
        if (1 == 1) {
            throw new NetworkException();
        }
        return 0;
    }
}
