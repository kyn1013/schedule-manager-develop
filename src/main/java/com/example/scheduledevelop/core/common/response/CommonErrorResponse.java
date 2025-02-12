package com.example.scheduledevelop.core.common.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CommonErrorResponse {

    private String status;
    private String message;
    private int code;


    public CommonErrorResponse(HttpStatus status, String message){
        this.status = status.name();
        this.code = status.value();
        this.message = message;
    }

}
