package com.app.quickFund.dto;

import com.app.quickFund.entities.BankName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankRequestDto {

    private BankName name;
    private String ifsc;
    private String branchCode;
    private boolean isActive;
}
