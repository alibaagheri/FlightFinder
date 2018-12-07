package com.northland.CheapFlightFinder.errorhandling.exception;

/**
 *
 * CustomException class is a child of RuntimeException and has been created to provide more flexibility in handling custom exceptions.
 *
 * @author  Ali Bagheri
 *
 */
public class CustomException extends RuntimeException {
    public CustomException(String exception) {
        super(exception);
    }
}
