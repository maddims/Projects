package com.hcl.db.nace.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class NaceExceptionHandler {

    @ExceptionHandler(NaceDetailsNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNaceDetailsNotFoundException(NaceDetailsNotFoundException exception){
            return exception.getMessage();
    }
}
