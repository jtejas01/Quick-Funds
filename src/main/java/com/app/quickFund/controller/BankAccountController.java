package com.app.quickFund.controller;

import com.app.quickFund.dto.BankAccountDto;
import com.app.quickFund.dto.BankDto;
import com.app.quickFund.services.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bankAccount")
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    @PostMapping("/create")
    public ResponseEntity<BankAccountDto> createBankAccount(@RequestBody BankAccountDto bankAccountDto){
        BankAccountDto bankAccount = bankAccountService.createBank(bankAccountDto);
        return new ResponseEntity<>(bankAccount, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<BankAccountDto> getBankAccountById(@PathVariable("id") Long bankAccountId){
        BankAccountDto bankAccount = bankAccountService.getByBankId(bankAccountId);
        return ResponseEntity.ok(bankAccount);
    }
    @GetMapping
    public ResponseEntity<List<BankAccountDto>> getAllBankAccounts(){
        List<BankAccountDto> bankAccountList = bankAccountService.getAllBankAccounts();
        return ResponseEntity.ok(bankAccountList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBankAccount(@PathVariable("id") Long bankAccountId){
        bankAccountService.deleteBankAccount(bankAccountId);
        return ResponseEntity.noContent().build();
    }
}
