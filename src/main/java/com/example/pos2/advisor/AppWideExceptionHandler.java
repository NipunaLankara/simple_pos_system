package com.example.pos2.advisor;

import com.example.pos2.exception.DuplicateKeyException;
import com.example.pos2.exception.NotFoundException;
import com.example.pos2.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler (NotFoundException.class)
    public ResponseEntity<StandardResponse> handleNotFoundException(NotFoundException exception){
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(404,"Error!!!!",exception),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler (DuplicateKeyException.class)
    public ResponseEntity<StandardResponse> handleDuplicateKeyException(DuplicateKeyException exception){
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(404,"Error",exception),
                HttpStatus.ALREADY_REPORTED
        );
    }

}
