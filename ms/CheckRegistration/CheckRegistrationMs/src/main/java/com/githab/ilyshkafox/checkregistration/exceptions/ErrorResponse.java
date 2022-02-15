package com.githab.ilyshkafox.checkregistration.exceptions;

import lombok.Data;

@Data
public class ErrorResponse {
    private final String code ;
    private final String message;
    private final Object data;
}
