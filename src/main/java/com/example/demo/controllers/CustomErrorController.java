package com.example.demo.controllers;

import com.example.demo.entity.ErrorModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@RestController
public class CustomErrorController implements ErrorController {
    //HttpStatus.ok
    @Autowired
    private ErrorAttributes errorAttributes;
    private  static  final Logger log = LoggerFactory.getLogger(CustomErrorController.class);
    @RequestMapping("/error")
    private ResponseEntity<?> getErrors(WebRequest request){
        Map<String, Object> att = errorAttributes.getErrorAttributes(request, ErrorAttributeOptions.of(ErrorAttributeOptions.Include.BINDING_ERRORS, ErrorAttributeOptions.Include.EXCEPTION, ErrorAttributeOptions.Include.MESSAGE, ErrorAttributeOptions.Include.STACK_TRACE));
        ResponseEntity.status(500);
        log.error("Hasan2SalakOsman");
        ErrorModel er= new ErrorModel();
        er.setAbc(500L);
        return  new ResponseEntity<>(er, HttpStatus.INTERNAL_SERVER_ERROR);

    }

}
