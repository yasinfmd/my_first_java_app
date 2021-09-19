package com.example.demo.config;

import com.example.demo.entity.BaseResponse;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class BaseResponseConfig <T> {

    public BaseResponse<T> getBaseResponse(T result, Date responseTime, boolean success, int code, Long milisecondDiff, String message){
        return  new BaseResponse<T>(result,responseTime,success,code,milisecondDiff,message);
    }
}
