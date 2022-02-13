package com.githab.ilyshkafox.checkregistration.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ExceptionHelper {
    public static final String CODE_DUPLICATE = "checkregistration.error.duplicate";


    public BusinessException createDuplicateException(String msg, String id, Throwable cause) {
        return new BusinessException(CODE_DUPLICATE, HttpStatus.CONFLICT, new DuplicateRecordResponse(id), msg, cause);
    }


}
