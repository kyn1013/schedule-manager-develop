package com.example.scheduledevelop.core.common.exception;

import org.springframework.http.HttpStatus;

public class CommentNotFoundException extends ApplicationException{
    public CommentNotFoundException() {
        super("존재하지 않는 댓글입니다.", HttpStatus.NOT_FOUND);
    }
}
