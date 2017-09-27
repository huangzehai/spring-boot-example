package com.hzh.web.listener;

import com.hzh.web.event.CustomEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class CustomEventHandler implements ApplicationListener<CustomEvent> {
    private Logger logger = LoggerFactory.getLogger(CustomEventHandler.class);

    @Override
    public void onApplicationEvent(CustomEvent event) {
        logger.info("Custom event");
    }
}
