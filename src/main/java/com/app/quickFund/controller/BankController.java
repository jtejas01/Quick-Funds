package com.app.quickFund.controller;

import com.app.quickFund.dto.BankDto;
import com.app.quickFund.dto.UserDto;
import com.app.quickFund.services.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank")
public class BankController {

    @Autowired
    private BankService bankService;

    @PostMapping("/create")
    public ResponseEntity<BankDto> createBank(@RequestBody BankDto bankDto){

        BankDto bank = bankService.createBank(bankDto);
        return new ResponseEntity<>(bank,HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<BankDto> getBankById(@PathVariable("id") Long bankId){
        BankDto bank = bankService.getBankById(bankId);
        return ResponseEntity.ok(bank);
    }
    @GetMapping
    public ResponseEntity<List<BankDto>> getAllBanks(){
       List<BankDto> bank = bankService.getAllBanks();
        return ResponseEntity.ok(bank);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BankDto> updateBank(@RequestBody BankDto bankDto,@PathVariable Long id){
        BankDto bank = bankService.updateBank(bankDto,id);
        return ResponseEntity.ok(bank);
    }
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteBank(@PathVariable Long id){
        bankService.deleteBank(id);
        return  ResponseEntity.noContent().build();
    }
}
