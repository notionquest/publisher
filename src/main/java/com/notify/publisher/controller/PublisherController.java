package com.notify.publisher.controller;

import com.notify.publisher.model.Notification;
import com.notify.publisher.service.Notify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import static com.notify.publisher.util.ApplicationConstant.INVALID_NOTIFY_TYPE;

import java.util.List;

@RestController
public class PublisherController {

    @Autowired
    List<Notify> notifyList;

    @GetMapping("/notify/{notifyType}")
    public Notification notify(@PathVariable String notifyType, @RequestParam(value="", defaultValue = "Hello world!!!") String message) {
        Notify notify = notifyList.stream().filter(e -> e.getType().equalsIgnoreCase(notifyType)).findFirst().orElseThrow(() -> new IllegalArgumentException(INVALID_NOTIFY_TYPE));
        return notify.notify(message);
    }
}
