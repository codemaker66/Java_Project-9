package com.footforwarddevelopmentconsultancy.mediscreen.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    /**
     * This method is called whenever there are a resource exception.
     *
     * @param e is an object of type ResourceException.
     * @return a ResponseEntity containing the HttpStatus and a message.
     */
    @ExceptionHandler(ResourceException.class)
    public ResponseEntity<String> handleResourceException(ResourceException e) {
        return ResponseEntity.status(e.getHttpStatus()).body(e.getMessage());
    }
}
