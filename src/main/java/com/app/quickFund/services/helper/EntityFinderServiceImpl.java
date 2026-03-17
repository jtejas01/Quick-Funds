package com.app.quickFund.services.helper;

import com.app.quickFund.entities.*;
import com.app.quickFund.exception.ErrorCode;
import com.app.quickFund.exception.custom.CustomException;
import com.app.quickFund.repositories.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EntityFinderServiceImpl implements EntityFinderService{

    private final UserRepository userRepository;
    private final BankRepository bankRepository;
    private final BankAccountRepository bankAccountRepository;
    private final TransactionRepository transactionRepository;
    private final LedgerEntryRepository ledgerEntryRepository;

    @Override
    public UserEntity getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(()-> new CustomException(ErrorCode.USER_NOT_FOUND));
    }

    @Override
    public UserEntity getUserByPhone(String phone) {
        return userRepository.findByPhone(phone).orElseThrow(()-> new CustomException(ErrorCode.PHONE_NUMBER_NOT_FOUND));
    }

    @Override
    public UserEntity getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(()-> new CustomException(ErrorCode.USER_NOT_FOUND));
    }

    @Override
    public BankAccountEntity getBankAccountById(Long accountNumber) {
        return bankAccountRepository.findById(accountNumber).orElseThrow(()-> new CustomException(ErrorCode.BANK_ACCOUNT_NOT_FOUND));
    }

    @Override
    public BankEntity getBankById(Long bankId) {
        return bankRepository.findById(bankId).orElseThrow(() -> new CustomException(ErrorCode.BANK_NOT_FOUND));
    }

    @Override
    public TransactionEntity getTransactionById(Long transactionId) {
        return transactionRepository.findById(transactionId).orElseThrow(()-> new CustomException(ErrorCode.TRANSACTION_NOT_FOUND));
    }

    @Override
    public LedgerEntryEntity getLedgerEntryById(Long ledgerEntryId) {
        return ledgerEntryRepository.findById(ledgerEntryId).orElseThrow(()-> new CustomException(ErrorCode.LEDGER_ENTRY_NOT_FOUND));
    }
}
