package com.northland.CheapFlightFinder.errorhandling.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

/**
 *
 * This controller class is being used to handle the custom exceptions of different classes.
 *
 * @author  Ali Bagheri
 *
 */
@ControllerAdvice
@RestController
public class CustomResponseEntityErrorHandler extends ResponseEntityExceptionHandler {
    /**
     * Creates an instance of ErrorDetails class and return it back.
     * @param ex the exception
     * @param request the web request
     * @return ResponseEntity of ErrorDetails class
     */
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetails> handleCustomException(Exception ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
