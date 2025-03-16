package com.example.pos2.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ALREADY_REPORTED)
public class DuplicateKeyException extends RuntimeException{

    public DuplicateKeyException (String message) {
        super(message);
    }
}
