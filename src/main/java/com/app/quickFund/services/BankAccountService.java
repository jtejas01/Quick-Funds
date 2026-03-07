package com.app.quickFund.services;

import com.app.quickFund.dto.BankAccountDto;
import com.app.quickFund.dto.BankDto;

import java.util.List;

public interface BankAccountService {

    BankAccountDto createBank(BankAccountDto bankAccountDto);
    BankAccountDto getByBankId(Long bankAccountNumber);
    List<BankAccountDto> getAllBankAccounts();
    BankAccountDto updateBankAccount(BankAccountDto bankAccountDto,Long bankAccountNumber);
    void deleteBankAccount(Long bankAccountId);
}
