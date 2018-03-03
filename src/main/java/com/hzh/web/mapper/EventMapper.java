package com.hzh.web.mapper;

import com.hzh.web.model.Event;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EventMapper {
    int addEvent(Event event);
}
