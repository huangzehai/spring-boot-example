package com.hzh.web.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStopListener implements ApplicationListener<ContextClosedEvent> {

    private Logger logger = LoggerFactory.getLogger(ApplicationStopListener.class);

    @Override
    public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {
        logger.info("Web application stop");
    }
}
