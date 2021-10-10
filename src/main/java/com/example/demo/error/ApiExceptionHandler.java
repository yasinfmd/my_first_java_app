package com.example.demo.error;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class ApiExceptionHandler {
  /*  @ExceptionHandler({CustomException.class})
    public ResponseEntity<Object> getError(CustomException exception, WebRequest request){
        exception.setEndpoint(request.getDescription(true));
        Map<String,Object> errorResponse=new HashMap<>();
        errorResponse.put("message",exception.getErrorMessage());
        errorResponse.put("code",exception.getCode());
        errorResponse.put("timeStamp",exception.getTimestamp());
        errorResponse.put("path",exception.getEndpoint());
        return  new ResponseEntity<>(errorResponse,new HttpHeaders(),exception.getCode());
    }*/
}
