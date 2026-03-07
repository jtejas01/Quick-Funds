package com.app.quickFund.services;

import com.app.quickFund.dto.BankAccountDto;
import com.app.quickFund.dto.BankDto;
import com.app.quickFund.dto.LedgerEntryDto;
import com.app.quickFund.dto.TransactionDto;
import com.app.quickFund.entities.BankAccountEntity;
import com.app.quickFund.entities.TransactionEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public interface LedgerEntryService {

    void createLedgerEntries(
            TransactionEntity txn,
            BankAccountEntity sender,
            BankAccountEntity receiver,
            BigDecimal amount

    );
    List<LedgerEntryDto>getLedgerByAccount(Long accountId);
    List<LedgerEntryDto>getLedgerByTransaction(Long transactionId);


}

