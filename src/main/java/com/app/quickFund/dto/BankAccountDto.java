package com.app.quickFund.dto;

import com.app.quickFund.entities.BankAccountType;
import com.app.quickFund.entities.BankEntity;
import com.app.quickFund.entities.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountDto {

    private BankAccountType bankAccountType;
    private Double balance;
    private String currency = "INR";

    private Long dailyTransferLimit;
    private boolean isActive;
    private Long userId;
    private Long bankId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
