package com.example.scheduledevelop.core.common.exception;

import org.springframework.http.HttpStatus;

public class ScheduleNotFoundException extends ApplicationException{
    public ScheduleNotFoundException() {
        super("존재하지 않는 일정입니다.", HttpStatus.NOT_FOUND);
    }
}
