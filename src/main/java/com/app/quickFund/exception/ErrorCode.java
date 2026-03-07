package com.app.quickFund.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Unexpected server error"),
    INVALID_REQUEST(HttpStatus.BAD_REQUEST, "Invalid request"),

    // Resource errors
    ID_NOT_FOUND(HttpStatus.NOT_FOUND, "Requested resource not found"),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "User not found"),
    BANK_NOT_FOUND(HttpStatus.NOT_FOUND,"Bank Not Found"),
    TRANSACTION_NOT_FOUND(HttpStatus.NOT_FOUND, "Transaction not found"),
    PHONE_NUMBER_NOT_FOUND(HttpStatus.NOT_FOUND,"phone number not found"),
    BANK_ACCOUNT_NOT_FOUND(HttpStatus.NOT_FOUND,"Bank Account Not Found"),
    LEDGER_ENTRY_NOT_FOUND(HttpStatus.NOT_FOUND,"Ledger Entry Not Found"),
    // Account related
    ACCOUNT_NOT_ACTIVE(HttpStatus.BAD_REQUEST, "Bank account is not active"),
    INSUFFICIENT_BALANCE(HttpStatus.BAD_REQUEST, "Insufficient balance in account"),

    // Transaction related
    INVALID_TRANSFER(HttpStatus.BAD_REQUEST, "Sender and receiver account cannot be the same"),
    INVALID_AMOUNT(HttpStatus.BAD_REQUEST, "Transfer amount must be greater than zero");


    private final HttpStatus status;
    private final String message;

}
