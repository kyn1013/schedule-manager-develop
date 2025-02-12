package com.example.scheduledevelop.core.common.exception;

import org.springframework.http.HttpStatus;

public class MemberNotFoundException extends ApplicationException{
    public MemberNotFoundException() {
        super("존재하지 않는 회원입니다.", HttpStatus.NOT_FOUND);
    }
}
