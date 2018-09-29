package com.notify.publisher.exception;

import static com.notify.publisher.util.ApplicationConstant.ERROR;
import com.notify.publisher.model.Notification;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value
            = { IllegalArgumentException.class})
    protected ResponseEntity<Object> badRequest(
            RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, new Notification("invalid", ERROR),
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
