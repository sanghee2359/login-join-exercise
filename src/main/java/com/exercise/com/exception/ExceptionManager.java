package com.exercise.com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
// RestControllerAdvice를 사용하면 각 계층에서 바로 RestControllerAdvice에 예외를 전달하여, 어떤 계층에서 예외가 발생하여도 바로 User에게 전달할 수 있다.

@RestControllerAdvice
public class ExceptionManager {
    @ExceptionHandler(AppException.class) // 특정 exception을 받아 처리할 수 있다.
    public ResponseEntity<?> appExceptionHandler(AppException e) { // runtimeException에러를 처리하는 handler
        return ResponseEntity.status(e.getErrorCode().getHttpStatus())
                .body(e.getErrorCode().name()+" "+e.getMessage());
    }
    @ExceptionHandler(RuntimeException.class) // 특정 exception을 받아 처리할 수 있다.
    public ResponseEntity<?> runtimeExceptionHandler(RuntimeException e) { // runtimeException에러를 처리하는 handler
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(e.getMessage());
    }
}
