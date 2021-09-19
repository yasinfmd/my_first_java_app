package com.example.demo.entity;

import org.springframework.http.ResponseEntity;

import java.util.Date;

public class BaseResponse<T> {

    private T result;

    private Date responseTime;

    private boolean success;

    private int code;

    private Long milisecondDiff;



    private String message;

    public BaseResponse(T result, Date responseTime, boolean success, int code, Long milisecondDiff, String message) {
        this.result = result;
        this.responseTime = responseTime;
        this.success = success;
        this.code = code;
        this.milisecondDiff = milisecondDiff;
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public Date getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Date responseTime) {
        this.responseTime = responseTime;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Long getMilisecondDiff() {
        return milisecondDiff;
    }

    public void setMilisecondDiff(Long milisecondDiff) {
        this.milisecondDiff = milisecondDiff;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
