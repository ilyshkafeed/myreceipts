package com.githab.ilyshkafox.checkregistration.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class BusinessException extends RuntimeException {
    private final Object data;
    private final String code;
    private final HttpStatus httpStatus;

    public BusinessException(String code, HttpStatus httpStatus, Object data, String message, Throwable cause) {
        super(message, cause);
        this.data = data;
        this.httpStatus = httpStatus;
        this.code = code;
    }
}
