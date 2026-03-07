package com.app.quickFund.services;

import com.app.quickFund.dto.BankAccountDto;
import com.app.quickFund.entities.BankAccountEntity;
import com.app.quickFund.entities.BankEntity;
import com.app.quickFund.entities.UserEntity;
import com.app.quickFund.exception.ErrorCode;
import com.app.quickFund.exception.custom.CustomException;
import com.app.quickFund.repositories.BankAccountRepository;
import com.app.quickFund.repositories.BankRepository;
import com.app.quickFund.repositories.UserRepository;
import com.app.quickFund.services.helper.EntityFinderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BankAccountServiceImpl implements BankAccountService{

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private ModelMapper modelMapper;

    private EntityFinderService entityFinderService;

    @Override
    public BankAccountDto createBank(BankAccountDto bankAccountDto) {
        BankAccountEntity bankAccount = modelMapper.map(bankAccountDto,BankAccountEntity.class);
        UserEntity user = entityFinderService.getUserById(bankAccountDto.getUserId());
        BankEntity bank = entityFinderService.getBankById(bankAccountDto.getBankId());
        bankAccount.setUser(user);
        bankAccount.setBank(bank);
        bankAccount.setCreatedAt(LocalDateTime.now());
        BankAccountEntity savedBankAccount = bankAccountRepository.save(bankAccount);
        return modelMapper.map(savedBankAccount,BankAccountDto.class);
    }

    @Override
    public BankAccountDto getByBankId(Long bankAccountNumber) {
        BankAccountEntity bankAccount = entityFinderService.getBankAccountById(bankAccountNumber);
        return modelMapper.map(bankAccount,BankAccountDto.class);
    }

    @Override
    public List<BankAccountDto> getAllBankAccounts() {
        List<BankAccountEntity> bankAccountList = bankAccountRepository.findAll();
        return bankAccountList.stream().map(bankAccount -> modelMapper.map(bankAccount,BankAccountDto.class)).collect(Collectors.toList());
    }

    @Override
    public BankAccountDto updateBankAccount(BankAccountDto bankAccountDto, Long bankAccountId) {
        BankAccountEntity bankAccount = entityFinderService.getBankAccountById(bankAccountId);
        modelMapper.map(bankAccountDto,bankAccount);
        BankAccountEntity updatedBankAccount = bankAccountRepository.save(bankAccount);
        return modelMapper.map(updatedBankAccount,BankAccountDto.class);

    }

    @Override
    public void deleteBankAccount(Long bankAccountId) {
        BankAccountEntity bankAccount = entityFinderService.getBankAccountById(bankAccountId);
    }
}
