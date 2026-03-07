package com.app.quickFund.services.helper;

import com.app.quickFund.entities.*;
import jakarta.transaction.Transaction;
import org.apache.catalina.User;

public interface EntityFinderService {

    UserEntity getUserById(Long userId);
    UserEntity getUserByPhone(String phone);
    UserEntity getUserByEmail(String email);
    BankAccountEntity getBankAccountById(Long accountNumber);
    BankEntity getBankById(Long bankId);
    TransactionEntity getTransactionById(Long transactionId);
    LedgerEntryEntity getLedgerEntryById(Long ledgerEntryId);


}
