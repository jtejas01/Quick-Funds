package com.app.quickFund.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

    private LocalDateTime timeStamp;
    private int status;
    private String error;
    private String message;

    public ErrorResponse(int status,String error, String message){
        this.timeStamp = LocalDateTime.now();
        this.error = error;
        this.message = message;
        this.status = status;
    }
}
