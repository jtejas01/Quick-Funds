package com.app.quickFund.services;

import com.app.quickFund.dto.TransactionResponseDto;
import com.app.quickFund.dto.TransferRequestDto;

public interface PaymentService {
    public TransactionResponseDto processTransfer(TransferRequestDto requestDto);
}
