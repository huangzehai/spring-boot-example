package com.hzh.web.service;

import com.hzh.web.mapper.UserMapper;
import com.hzh.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public int addUser(User user) {
        return userMapper.addUser(user);
    }
}
