package com.githab.ilyshkafox.checkregistration.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomAdvice {
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleException(BusinessException e) {
        ErrorResponse response = new ErrorResponse(
                e.getCode(),
                e.getMessage(),
                e.getData()
        );
        return new ResponseEntity<>(response, e.getHttpStatus());
    }
}
