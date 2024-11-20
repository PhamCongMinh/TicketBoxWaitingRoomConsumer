package org.ticketbox.shared.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
public class ErrorResponse {
    private String errorCode;
    private String message;
    private int status;
    private Date timestamp;

    public ErrorResponse(String errorCode, String message, HttpStatus status, Date timestamp) {
        this.errorCode = errorCode;
        this.message = message;
        this.status = status.value();
        this.timestamp = timestamp;
    }

    public ErrorResponse(String message, HttpStatus status, Date timestamp) {
        this.message = message;
        this.status = status.value();
        this.timestamp = timestamp;
    }
}
