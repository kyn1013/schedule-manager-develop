package com.example.scheduledevelop.core.common.exception;

import org.springframework.http.HttpStatus;

public class UnauthorizedException extends ApplicationException{
    public UnauthorizedException() {
        super("로그인이 필요합니다.",HttpStatus.UNAUTHORIZED);
    }
}
