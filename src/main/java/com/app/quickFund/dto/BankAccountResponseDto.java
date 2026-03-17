package com.app.quickFund.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountResponseDto {
    private Long accountNumber;
    private BigDecimal balance;
    private String currency;
    private boolean active;

    private UserResponseDto user;
    private BankResponseDto bank;

    private LocalDateTime createdAt;
}
