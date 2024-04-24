package com.example.springbrrowbook.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookException {
    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Exception exception) {
        System.out.println(exception.getMessage());
        return "/error";
    }
}
