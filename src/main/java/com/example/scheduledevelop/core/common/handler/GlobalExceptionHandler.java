package com.example.scheduledevelop.core.common.handler;

import com.example.scheduledevelop.core.common.exception.ApplicationException;
import com.example.scheduledevelop.core.common.response.CommonErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /*
     * 런타임 에러 발생 핸들러
     */
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<CommonErrorResponse> handleApplicationException(ApplicationException e){
        CommonErrorResponse errorResponse = new CommonErrorResponse(e.getStatus(), e.getMessage());
        log.error("[ApplicationExceptionHandler] ApplicationException = {}, class = {}", e.getMessage(), e.getClass());
        return new ResponseEntity<>(errorResponse, e.getStatus());
    }

    /*
     * Dto 검증이 잘못된 경우에 발생하는 에러를 관리하는 핸들러
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CommonErrorResponse> handleValidationException(MethodArgumentNotValidException ex) {
//        String firstErrorMessage = ex.getBindingResult()
//                .getFieldErrors()
//                .stream()
//                .findFirst()
//                .map(DefaultMessageSourceResolvable::getDefaultMessage)
//                .orElseThrow(() -> new IllegalStateException("검증 에러가 반드시 존재해야 합니다."));
        String firstErrorMessage = null;
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            firstErrorMessage = fieldError.getDefaultMessage();
            break;
        }

        CommonErrorResponse errorResponse = new CommonErrorResponse(HttpStatus.BAD_REQUEST, firstErrorMessage);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
