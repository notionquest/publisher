package com.notify.publisher.controller;

import com.notify.publisher.model.Notification;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static com.notify.publisher.util.ApplicationConstant.ERROR;
import static com.notify.publisher.util.ApplicationConstant.SUCCESS;
import static org.assertj.core.api.BDDAssertions.then;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PublisherControllerIT {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void shouldReturn200WhenNotifyEmail() throws Exception {
        @SuppressWarnings("rawtypes")
        ResponseEntity<Notification> entity = this.testRestTemplate.getForEntity(
                "http://localhost:" + this.port + "/notify/EMAIL?message=" + "email message", Notification.class);

        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(entity.getBody().getType()).isEqualTo("EMAIL");
        then(entity.getBody().getStatus()).isEqualTo(SUCCESS);
    }

    @Test
    public void shouldReturn200WhenNotifySms() throws Exception {
        @SuppressWarnings("rawtypes")
        ResponseEntity<Notification> entity = this.testRestTemplate.getForEntity(
                "http://localhost:" + this.port + "/notify/SMS?message=" + "sms message", Notification.class);

        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(entity.getBody().getType()).isEqualTo("SMS");
        then(entity.getBody().getStatus()).isEqualTo(SUCCESS);
    }

    @Test
    public void shouldReturn400WhenNotifySms() throws Exception {
        @SuppressWarnings("rawtypes")
        ResponseEntity<Notification> entity = this.testRestTemplate.getForEntity(
                "http://localhost:" + this.port + "/notify/invalidtype?message=" + "invalid message", Notification.class);

        then(entity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        then(entity.getBody().getType()).isEqualTo("invalid");
        then(entity.getBody().getStatus()).isEqualTo(ERROR);
    }

}