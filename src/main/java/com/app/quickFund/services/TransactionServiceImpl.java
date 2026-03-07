package com.app.quickFund.services;

import com.app.quickFund.dto.TransactionDto;
import com.app.quickFund.dto.TransferRequestDto;
import com.app.quickFund.entities.BankAccountEntity;
import com.app.quickFund.entities.TransactionEntity;
import com.app.quickFund.exception.ErrorCode;
import com.app.quickFund.exception.custom.CustomException;
import com.app.quickFund.repositories.TransactionRepository;
import com.app.quickFund.services.helper.EntityFinderService;
import lombok.AllArgsConstructor;
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
    public TransactionDto transferMoney(TransferRequestDto requestDto) {
        return paymentService.processTransfer(requestDto);
    }

    @Override
    public TransactionDto getTransactionById(Long transactionId) {
        TransactionEntity transaction = entityFinderService.getTransactionById(transactionId);
        return modelMapper.map(transaction,TransactionDto.class);
    }

    @Override
    public List<TransactionDto> getAlltransactions() {
        List<TransactionEntity> transactionList = transactionRepository.findAll();
        return transactionList.stream().map(transaction -> modelMapper.map(transaction,TransactionDto.class)).collect(Collectors.toList());
    }
}



