package com.app.quickFund.services;

import com.app.quickFund.dto.BankRequestDto;
import com.app.quickFund.dto.BankResponseDto;
import com.app.quickFund.entities.BankEntity;
import com.app.quickFund.repositories.BankRepository;
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
public class BankServiceImpl implements BankService{

    @Autowired
    public ModelMapper modelMapper;

    @Autowired
    public BankRepository bankRepository;

    private final EntityFinderService entityFinderService;
    @Override
    public BankResponseDto createBank(BankRequestDto bank) {
        BankEntity bankEntity = modelMapper.map(bank,BankEntity.class);
        bankEntity.setCreatedAt(LocalDateTime.now());
        BankEntity savedBank = bankRepository.save(bankEntity);
        return modelMapper.map(savedBank, BankResponseDto.class);
    }

    @Override
    public BankResponseDto getBankById(Long bankId) {
        BankEntity bank = entityFinderService.getBankById(bankId);
        return modelMapper.map(bank, BankResponseDto.class);
    }

    @Override
    public List<BankResponseDto> getAllBanks() {

        List<BankEntity> bankEntity = bankRepository.findAll();
        return bankEntity.stream().map(bank -> modelMapper.map(bank, BankResponseDto.class)).collect(Collectors.toList());
    }

    @Override
    public BankResponseDto updateBank(BankRequestDto bankRequestDto, Long bankId) {
        BankEntity existingBank = entityFinderService.getBankById(bankId);
        modelMapper.map(bankRequestDto,existingBank);
        existingBank.getCreatedAt();
        existingBank.setUpdatedAt(LocalDateTime.now());
        BankEntity updatedBank = bankRepository.save(existingBank);
        return modelMapper.map(updatedBank, BankResponseDto.class);
    }

    @Override
    public void deleteBank(Long bankId) {

        BankEntity bank = entityFinderService.getBankById(bankId);
        bankRepository.delete(bank);
    }
}
