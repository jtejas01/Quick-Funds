package com.app.quickFund.services;

import com.app.quickFund.dto.TransactionResponseDto;
import com.app.quickFund.dto.TransferRequestDto;

import java.util.List;

public interface TransactionService {

    TransactionResponseDto transferMoney(TransferRequestDto requestDto);
    TransactionResponseDto getTransactionById(Long transactionId);
    List<TransactionResponseDto> getAlltransactions();

}
