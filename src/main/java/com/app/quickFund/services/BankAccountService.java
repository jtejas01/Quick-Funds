package com.app.quickFund.services;

import com.app.quickFund.dto.BankAccountRequestDto;
import com.app.quickFund.dto.BankAccountResponseDto;
import com.app.quickFund.dto.BankResponseDto;

import java.util.List;

public interface BankAccountService {

        BankAccountResponseDto createBankAccount(BankAccountRequestDto bankAccountRequestDto);
    BankAccountResponseDto getByBankAccountById(Long bankAccountNumber);
    List<BankAccountResponseDto> getAllBankAccounts();
    BankAccountResponseDto updateBankAccount(BankAccountRequestDto bankAccountRequestDto, Long bankAccountNumber);
    BankAccountResponseDto deleteBankAccount(Long bankAccountId);
}
