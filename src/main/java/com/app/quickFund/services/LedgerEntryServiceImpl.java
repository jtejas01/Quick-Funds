package com.app.quickFund.services;

import com.app.quickFund.dto.BankAccountDto;
import com.app.quickFund.dto.LedgerEntryDto;
import com.app.quickFund.dto.TransactionDto;
import com.app.quickFund.entities.BankAccountEntity;
import com.app.quickFund.entities.LedgerEntryEntity;
import com.app.quickFund.entities.TransactionEntity;
import com.app.quickFund.exception.ErrorCode;
import com.app.quickFund.exception.custom.CustomException;
import com.app.quickFund.repositories.LedgerEntryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class LedgerEntryServiceImpl implements LedgerEntryService{


    private final LedgerEntryRepository ledgerEntryRepository;


    private final ModelMapper modelMapper;

    public void createLedgerEntries(TransactionEntity txn, BankAccountEntity sender, BankAccountEntity receiver, BigDecimal amount){
        LedgerEntryEntity debit = new LedgerEntryEntity();
        debit.setTransaction(txn);
        debit.setBankAccount(sender);
        debit.setAmount(amount);
        debit.setBalanceAfterTransaction(sender.getBalance());

        LedgerEntryEntity credit = new LedgerEntryEntity();
        credit.setTransaction(txn);
        credit.setBankAccount(receiver);
        credit.setAmount(amount);
        credit.setBalanceAfterTransaction(receiver.getBalance());

        ledgerEntryRepository.save(debit);
        ledgerEntryRepository.save(credit);
    }
    @Override
    public List<LedgerEntryDto> getLedgerByAccount(Long accountId) {
        List<LedgerEntryEntity> entries = ledgerEntryRepository.findByBankAccountAccountNumberOrderByCreatedAtDesc(accountId).orElseThrow (()->new CustomException(ErrorCode.ID_NOT_FOUND));
        return entries.stream().map(entry->modelMapper.map(entry,LedgerEntryDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<LedgerEntryDto> getLedgerByTransaction(Long transactionId) {
        List<LedgerEntryEntity> entries =
                ledgerEntryRepository.findByTransactionId(transactionId).orElseThrow(()->new CustomException(ErrorCode.ID_NOT_FOUND));
        return entries.stream().map(entry ->modelMapper.map(entry,LedgerEntryDto.class)).toList();
    }
}
