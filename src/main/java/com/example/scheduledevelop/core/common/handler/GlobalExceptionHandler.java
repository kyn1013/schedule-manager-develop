package com.example.scheduledevelop.core.common.handler;

import com.example.scheduledevelop.core.common.exception.ApplicationException;
import com.example.scheduledevelop.core.common.response.CommonErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /*
     * 런타임 에러 발생 핸들러
     */
    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<CommonErrorResponse> handleApplicationException(ApplicationException e){
        CommonErrorResponse errorResponse = new CommonErrorResponse(e.getStatus(), e.getMessage());
        log.error("[ApplicationExceptionHandler] ApplicationException = {}, class = {}", e.getMessage(), e.getClass());
        return new ResponseEntity<>(errorResponse, e.getStatus());
    }

    /*
     * Dto 검증이 잘못된 경우에 발생하는 에러를 관리하는 핸들러
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CommonErrorResponse> handleValidationException(MethodArgumentNotValidException e) {
//        String firstErrorMessage = ex.getBindingResult()
//                .getFieldErrors()
//                .stream()
//                .findFirst()
//                .map(DefaultMessageSourceResolvable::getDefaultMessage)
//                .orElseThrow(() -> new IllegalStateException("검증 에러가 반드시 존재해야 합니다."));
        String firstErrorMessage = null;
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            firstErrorMessage = fieldError.getDefaultMessage();
            break;
        }

        CommonErrorResponse errorResponse = new CommonErrorResponse(HttpStatus.BAD_REQUEST, firstErrorMessage);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    /*
     * 요청값이 객체로 변환되는게 실패한 경우 발생하는 에러를 관리하는 핸들러
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<CommonErrorResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException e){
        CommonErrorResponse errorResponse = new CommonErrorResponse(HttpStatus.BAD_REQUEST, "객체 바인딩이 실패하였습니다. 타입을 다시 확인해주세요.");
        log.error("[HttpMessageNotReadableExceptionHandler] HttpMessageNotReadableException = {}, class = {}", e.getMessage(), e.getClass());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
