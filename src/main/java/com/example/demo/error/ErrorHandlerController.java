package com.example.demo.error;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ErrorHandlerController implements ErrorController {

    @Autowired
    private ErrorAttributes errorAttributes;

    @RequestMapping("/error")
    public ResponseEntity<Object> getError(WebRequest request){
        Map<String, Object> errors = errorAttributes.getErrorAttributes(request, ErrorAttributeOptions.defaults());
        CustomException exception= (CustomException) errorAttributes.getError(request);
        Map<String,Object> errorResponse=new HashMap<>();
        errorResponse.put("message",exception.getErrorMessage());
        errorResponse.put("code",exception.getCode());
        errorResponse.put("timeStamp",exception.getTimestamp());
        errorResponse.put("path",errors.get("path"));
        return  new ResponseEntity<>(errorResponse,new HttpHeaders(),exception.getCode());
    }

}
