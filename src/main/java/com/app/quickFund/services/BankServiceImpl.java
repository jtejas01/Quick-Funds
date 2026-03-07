package com.app.quickFund.services;

import com.app.quickFund.dto.BankDto;
import com.app.quickFund.entities.BankEntity;
import com.app.quickFund.exception.ErrorCode;
import com.app.quickFund.exception.custom.CustomException;
import com.app.quickFund.repositories.BankRepository;
import com.app.quickFund.services.helper.EntityFinderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BankServiceImpl implements BankService{

    @Autowired
    public ModelMapper modelMapper;

    @Autowired
    public BankRepository bankRepository;

    private  EntityFinderService entityFinderService;
    @Override
    public BankDto createBank(BankDto bank) {
        BankEntity bankEntity = modelMapper.map(bank,BankEntity.class);
        BankEntity savedBank = bankRepository.save(bankEntity);
        return modelMapper.map(savedBank,BankDto.class);
    }

    @Override
    public BankDto getBankById(Long bankId) {
        BankEntity bank = entityFinderService.getBankById(bankId);
        return modelMapper.map(bank,BankDto.class);
    }

    @Override
    public List<BankDto> getAllBanks() {

        List<BankEntity> bankEntity = bankRepository.findAll();
        return bankEntity.stream().map(bank -> modelMapper.map(bank,BankDto.class)).collect(Collectors.toList());
    }

    @Override
    public BankDto updateBank(BankDto bankDto, Long bankId) {
        BankEntity existingBank = entityFinderService.getBankById(bankId);
        modelMapper.map(bankDto,existingBank);
        BankEntity updatedBank = bankRepository.save(existingBank);
        return modelMapper.map(updatedBank, BankDto.class);
    }

    @Override
    public void deleteBank(Long bankId) {

        BankEntity bank = entityFinderService.getBankById(bankId);
        bankRepository.delete(bank);
    }
}
