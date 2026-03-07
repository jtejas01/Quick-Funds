package com.app.quickFund.dto;

import com.app.quickFund.entities.TransactionStatus;
import com.app.quickFund.entities.TransctionType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {

        private Long id;
        private UUID transactionRef;
        private BigDecimal amount;
        private TransctionType transactionType;
        private TransactionStatus transactionStatus;
        private UserDto user;
        private BankAccountDto fromAccount;
        private BankAccountDto toAccount;

        private LocalDateTime initiatedAt;
        private LocalDateTime completedAt;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
}
