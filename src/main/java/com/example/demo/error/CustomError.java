package com.example.demo.error;

public class CustomError extends  Exception {
    private  String errorMsg;

    public CustomError(String message, Throwable cause, String errorMsg) {
        super(message, cause);
        this.errorMsg = errorMsg;
    }

    private String getErrorMessage(){
        return errorMsg;
    }
}
