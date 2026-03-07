package com.app.quickFund.dto;

import com.app.quickFund.entities.BankAccountEntity;
import com.app.quickFund.entities.Role;
import com.app.quickFund.entities.TransactionEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LedgerEntryDto {

    private Long id;
    private TransactionDto transaction;
    private BankAccountDto bankAccount;
    private Double amount;

    private Double balanceAfterTransaction;
    private LocalDateTime createdAt;
}
