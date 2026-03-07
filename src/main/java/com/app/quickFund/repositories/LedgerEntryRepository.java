package com.app.quickFund.repositories;

import com.app.quickFund.entities.LedgerEntryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LedgerEntryRepository extends JpaRepository<LedgerEntryEntity,Long> {

    Optional<List<LedgerEntryEntity>> findByBankAccountAccountNumberOrderByCreatedAtDesc(Long accountNumber);
    Optional<List<LedgerEntryEntity>> findByTransactionId(Long transactionId);
}
