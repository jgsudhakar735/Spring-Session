package com.jgsudhakar.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.spring.exception.ExceptionHandler
 * @Date : 11/10/2020
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(value=Exception.class)
    public ResponseEntity<ErrorRes> validationExceptionHandler(Exception ex){
        ErrorRes errorRes = new ErrorRes();
        errorRes.setCode(ex.getMessage());
        errorRes.setMessage(ex.getMessage());
        errorRes.setHttpStatus(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<ErrorRes>(errorRes, HttpStatus.OK);
    }
}
