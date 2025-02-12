package com.example.scheduledevelop.core.common.exception;

import org.springframework.http.HttpStatus;

public class InvalidPasswordException extends ApplicationException{
    public InvalidPasswordException() {
        super("비밀번호가 일치하지 않습니다.", HttpStatus.UNAUTHORIZED);
    }
}
