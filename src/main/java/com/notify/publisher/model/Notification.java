package com.notify.publisher.model;

import java.io.Serializable;

public class Notification implements Serializable {
    private String type;
    private String status;

    public Notification(String type, String status) {
        this.type = type;
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "type='" + type + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
