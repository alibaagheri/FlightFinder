package com.northland.CheapFlightFinder.errorhandling.exception;

import java.util.Date;

/**
 *
 * This class has been created to be able to display proper error details to the consumer.
 * The details includes timestamp of the exception, its message and the details of the exception.
 *
 * @author  Ali Bagheri
 *
 */
public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String details;

    public ErrorDetails(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

}
