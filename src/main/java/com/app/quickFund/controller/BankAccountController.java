package com.app.quickFund.controller;

import com.app.quickFund.dto.BankAccountRequestDto;
import com.app.quickFund.dto.BankAccountResponseDto;
import com.app.quickFund.dto.BankResponseDto;
import com.app.quickFund.services.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank-accounts")
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    @PostMapping("/create")
    public ResponseEntity<BankAccountResponseDto> createBankAccount(@RequestBody BankAccountRequestDto bankAccountRequestDto){
        BankAccountResponseDto bankAccount = bankAccountService.createBankAccount(bankAccountRequestDto);
        return new ResponseEntity<>(bankAccount, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<BankAccountResponseDto> getBankAccountById(@PathVariable("id") Long bankAccountId){
        BankAccountResponseDto bankAccount = bankAccountService.getByBankAccountById(bankAccountId);
        return ResponseEntity.ok(bankAccount);
    }
    @GetMapping
    public ResponseEntity<List<BankAccountResponseDto>> getAllBankAccounts(){
        List<BankAccountResponseDto> bankAccountList = bankAccountService.getAllBankAccounts();
        return ResponseEntity.ok(bankAccountList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BankAccountResponseDto> deleteBankAccount(@PathVariable("id") Long bankAccountId){
       BankAccountResponseDto bankAccount = bankAccountService.deleteBankAccount(bankAccountId);
        return ResponseEntity.ok(bankAccount);
    }
}
