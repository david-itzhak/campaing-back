package com.example.javatest.exception.handler;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.ConstraintViolationException;

/**
 * @author Dmitry Itskov
 */
@RestControllerAdvice
@Log4j2
public class RestControllerExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String constraintViolationExceptionHandler(ConstraintViolationException e) {
        return processingExceptionMessage(e);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String argumentValidExceptionHandler(MethodArgumentNotValidException e) {
        String fullMessage = processingExceptionMessage(e);
        int index = fullMessage.lastIndexOf("default message") + 16;
        return fullMessage.substring(index, fullMessage.length() - 2);
    }

    @ExceptionHandler(ResponseStatusException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String argumentValidExceptionHandler(ResponseStatusException e) {
        return processingExceptionMessage(e);
    }

    private String processingExceptionMessage(Throwable e) {
        log.info("===> Exception class: {}, message: {}.", e.getClass().getSimpleName(), e.getMessage());
        return e.getMessage();
    }
}
