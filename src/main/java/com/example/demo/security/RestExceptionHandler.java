package com.example.demo.security;

import com.example.demo.dto.ErrorDto;
import com.example.demo.exception.AppException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = { AppException.class })
    @ResponseBody
    public ResponseEntity<ErrorDto> handleException(AppException ex) {
        ErrorDto errorDto = new ErrorDto(ex.getMessage());
        return ResponseEntity
                .status(ex.getStatus())
                .body(errorDto);
    }
}
