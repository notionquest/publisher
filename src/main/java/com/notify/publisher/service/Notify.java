package com.notify.publisher.service;

import com.notify.publisher.model.Notification;

public interface Notify {

    String getType();
    Notification notify(String message);
}
