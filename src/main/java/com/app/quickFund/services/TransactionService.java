package com.app.quickFund.services;

import com.app.quickFund.dto.TransactionDto;
import com.app.quickFund.dto.TransferRequestDto;

import java.util.List;

public interface TransactionService {

    TransactionDto transferMoney(TransferRequestDto requestDto);
    TransactionDto getTransactionById(Long transactionId);
    List<TransactionDto> getAlltransactions();

}
