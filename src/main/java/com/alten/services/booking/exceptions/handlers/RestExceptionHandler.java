package com.alten.services.booking.exceptions.handlers;

import com.alten.services.booking.exceptions.InvalidDataException;
import com.alten.services.booking.models.Status;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value
            = {InvalidDataException.class})
    protected ResponseEntity<Object> handleInvalidData(
            InvalidDataException ex, WebRequest request) {
        Status status = new Status();
        status.setMessage(ex.getDescription());
        return handleExceptionInternal(ex, status, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value
            = {ConstraintViolationException.class})
    protected ResponseEntity<Object> handleConstraintViolationException(
            ConstraintViolationException ex, WebRequest request) {
        Status status = new Status();
        status.setMessage(ex.getMessage());
        return handleExceptionInternal(ex, status, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {
        final String errorMessage = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
        Status statusOperation = new Status();
        statusOperation.setMessage(errorMessage);

        return new ResponseEntity<>(statusOperation, status);
    }
}
