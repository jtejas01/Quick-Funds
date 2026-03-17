package com.app.quickFund.services;

import com.app.quickFund.dto.BankAccountRequestDto;
import com.app.quickFund.dto.BankAccountResponseDto;
import com.app.quickFund.entities.BankAccountEntity;
import com.app.quickFund.entities.BankEntity;
import com.app.quickFund.entities.UserEntity;
import com.app.quickFund.repositories.BankAccountRepository;
import com.app.quickFund.services.helper.EntityFinderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class BankAccountServiceImpl implements BankAccountService{

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private ModelMapper modelMapper;

    private final EntityFinderService entityFinderService;

    @Override
    public BankAccountResponseDto createBankAccount(BankAccountRequestDto bankAccountRequestDto) {
        BankAccountEntity bankAccount = modelMapper.map(bankAccountRequestDto,BankAccountEntity.class);
        UserEntity user = entityFinderService.getUserById(bankAccountRequestDto.getUserId());
        BankEntity bank = entityFinderService.getBankById(bankAccountRequestDto.getBankId());
        bankAccount.setUser(user);
        bankAccount.setBank(bank);
        bankAccount.setCreatedAt(LocalDateTime.now());
        BankAccountEntity savedBankAccount = bankAccountRepository.save(bankAccount);
        return modelMapper.map(savedBankAccount, BankAccountResponseDto.class);
    }

    @Override
    public BankAccountResponseDto getByBankAccountById(Long bankAccountNumber) {
        BankAccountEntity bankAccount = entityFinderService.getBankAccountById(bankAccountNumber);
        return modelMapper.map(bankAccount, BankAccountResponseDto.class);
    }

    @Override
    public List<BankAccountResponseDto> getAllBankAccounts() {
        List<BankAccountEntity> bankAccountList = bankAccountRepository.findAll();
        return bankAccountList.stream().map(bankAccount -> modelMapper.map(bankAccount, BankAccountResponseDto.class)).collect(Collectors.toList());
    }

    @Override
    public BankAccountResponseDto updateBankAccount(BankAccountRequestDto bankAccountRequestDto, Long bankAccountId) {
        BankAccountEntity bankAccount = entityFinderService.getBankAccountById(bankAccountId);
        modelMapper.map(bankAccountRequestDto,bankAccount);
        BankAccountEntity updatedBankAccount = bankAccountRepository.save(bankAccount);
        return modelMapper.map(updatedBankAccount, BankAccountResponseDto.class);

    }

    @Override
    public BankAccountResponseDto deleteBankAccount(Long bankAccountId) {
        BankAccountEntity bankAccount = entityFinderService.getBankAccountById(bankAccountId);
        bankAccount.setActive(false);
        bankAccountRepository.save(bankAccount);
        return modelMapper.map(bankAccount,BankAccountResponseDto.class);
    }
}
