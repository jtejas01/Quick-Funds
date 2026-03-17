package com.app.quickFund.services;

import com.app.quickFund.dto.TransactionResponseDto;
import com.app.quickFund.dto.TransferRequestDto;
import com.app.quickFund.entities.TransactionEntity;
import com.app.quickFund.repositories.TransactionRepository;
import com.app.quickFund.services.helper.EntityFinderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private PaymentService paymentService;

    private final EntityFinderService entityFinderService;

    @Override
    public TransactionResponseDto transferMoney(TransferRequestDto requestDto) {
        return paymentService.processTransfer(requestDto);
    }

    @Override
    public TransactionResponseDto getTransactionById(Long transactionId) {
        TransactionEntity transaction = entityFinderService.getTransactionById(transactionId);
        return modelMapper.map(transaction, TransactionResponseDto.class);
    }

    @Override
    public List<TransactionResponseDto> getAlltransactions() {
        List<TransactionEntity> transactionList = transactionRepository.findAll();
        return transactionList.stream().map(transaction -> modelMapper.map(transaction, TransactionResponseDto.class)).collect(Collectors.toList());
    }
}



