package com.example.naja.restapi.controllers.advices;

import com.example.naja.core.exceptions.NajaSemanticException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class NajaSemanticExceptionHandler {
    @ResponseStatus(BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(NajaSemanticException.class)
    public Error generalExceptionHandler(NajaSemanticException ex) {
        return new Error(ex.getMessage());
    }

    record Error(String message) {
    }
}