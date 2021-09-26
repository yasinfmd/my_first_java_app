package com.example.demo.error;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler({CustomException.class})
    public ResponseEntity<CustomException> getError(CustomException exception, WebRequest request){
        exception.setEndpoint(request.getDescription(true));
        System.out.println(request.getContextPath());
        System.out.println(exception.getErrorMessage());
        return  new ResponseEntity<CustomException>(exception,new HttpHeaders(),exception.getCode());
    }
}
