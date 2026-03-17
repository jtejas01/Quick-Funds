package com.app.quickFund.dto;

import com.app.quickFund.entities.BankAccountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountRequestDto {

    private BankAccountType bankAccountType;
    private String currency = "INR";

    private Long dailyTransferLimit;
    private boolean isActive;
    private Long userId;
    private Long bankId;

}
