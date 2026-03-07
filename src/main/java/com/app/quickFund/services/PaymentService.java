package com.app.quickFund.services;

import com.app.quickFund.dto.TransactionDto;
import com.app.quickFund.dto.TransferRequestDto;

public interface PaymentService {
    public TransactionDto processTransfer(TransferRequestDto requestDto);
}
