package com.notify.publisher.service;

import com.notify.publisher.model.Notification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import static com.notify.publisher.util.ApplicationConstant.SUCCESS;

@Service
public class EmailNotification implements Notify {

    Logger logger = LoggerFactory.getLogger(getClass());

    private String type = "EMAIL";

    @Override
    public String getType() {
        return type;
    }

    @Override
    public Notification notify(String message) {
        logger.info("Email notification");
        logger.info("Message :" + message);
        return new Notification(type, SUCCESS);
    }
}
