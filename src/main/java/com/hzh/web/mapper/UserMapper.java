package com.hzh.web.mapper;

import com.hzh.web.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int addUser(User user);
}
