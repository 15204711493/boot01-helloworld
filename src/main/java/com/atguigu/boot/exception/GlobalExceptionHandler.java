package com.atguigu.boot.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public String handlerArithException(Exception e){

        return e.getMessage();
    }
}
