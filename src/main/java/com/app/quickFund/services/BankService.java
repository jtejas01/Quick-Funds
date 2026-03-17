package com.app.quickFund.services;

import com.app.quickFund.dto.BankRequestDto;
import com.app.quickFund.dto.BankResponseDto;

import java.util.List;

public interface BankService {

    BankResponseDto createBank(BankRequestDto bank);
    BankResponseDto getBankById(Long bankId);
    List<BankResponseDto> getAllBanks();
    BankResponseDto updateBank(BankRequestDto bankRequestDto, Long bankId);
    void deleteBank (Long bankId);
}
