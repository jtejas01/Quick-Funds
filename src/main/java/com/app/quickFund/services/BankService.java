package com.app.quickFund.services;

import com.app.quickFund.dto.BankDto;

import java.util.List;

public interface BankService {

    BankDto createBank(BankDto bank);
    BankDto getBankById(Long bankId);
    List<BankDto> getAllBanks();
    BankDto updateBank(BankDto bankDto,Long bankId);
    void deleteBank (Long bankId);
}
