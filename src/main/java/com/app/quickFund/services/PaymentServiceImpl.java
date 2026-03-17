package com.app.quickFund.services;

import com.app.quickFund.dto.TransactionResponseDto;
import com.app.quickFund.dto.TransferRequestDto;
import com.app.quickFund.entities.BankAccountEntity;
import com.app.quickFund.entities.TransactionEntity;
import com.app.quickFund.entities.TransactionStatus;
import com.app.quickFund.exception.ErrorCode;
import com.app.quickFund.exception.custom.CustomException;
import com.app.quickFund.repositories.TransactionRepository;
import com.app.quickFund.services.helper.EntityFinderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private LedgerEntryService ledgerEntryService;


    private final EntityFinderService entityFinderService;

    @Override
    @Transactional
    public TransactionResponseDto processTransfer(TransferRequestDto requestDto) {

        BankAccountEntity sender = entityFinderService.getBankAccountById(requestDto.getFromAccountId());
        BankAccountEntity receiver = entityFinderService.getBankAccountById(requestDto.getToAccountId());

        if(sender.getAccountNumber().equals(receiver.getAccountNumber())){
            throw new CustomException(ErrorCode.INVALID_TRANSFER);
        }
        if(sender.getBalance().compareTo(requestDto.getAmount())<0){
            throw new CustomException(ErrorCode.INSUFFICIENT_BALANCE);
        }
        //Debit Sender
        sender.setBalance(sender.getBalance().subtract(requestDto.getAmount()));

        //credit receiver
        receiver.setBalance(receiver.getBalance().add(requestDto.getAmount()));

        //create Transaction
        TransactionEntity transaction = new TransactionEntity();
        transaction.setTransactionRef(UUID.randomUUID());
        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        transaction.setAmount(requestDto.getAmount());
        transaction.setFromAccount(sender);
        transaction.setToAccount(receiver);

        LocalDateTime now = LocalDateTime.now();
        transaction.setInitiatedAt(now);
        transaction.setCompletedAt(now);
        transaction.setCreatedAt(now);

        TransactionEntity savedTransaction = transactionRepository.save(transaction);

        ledgerEntryService.createLedgerEntries(savedTransaction,sender,receiver,requestDto.getAmount());
        return modelMapper.map(savedTransaction, TransactionResponseDto.class);
    }
}
