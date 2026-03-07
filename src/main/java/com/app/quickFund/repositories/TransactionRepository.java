package com.app.quickFund.repositories;

import com.app.quickFund.entities.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository<TransactionEntity,Long> {


    Optional<TransactionEntity> findByTransactionRef(UUID transactionRef);

    List<TransactionEntity> findByUserId(Long userId);

    List<TransactionEntity> findByFromAccount_AccountNumber(Long accountNumber);

    List<TransactionEntity> findByToAccount_AccountNumber(Long accountNumber);

}
