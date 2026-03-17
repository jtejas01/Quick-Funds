package com.app.quickFund.controller;

import com.app.quickFund.dto.BankRequestDto;
import com.app.quickFund.dto.BankResponseDto;
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
    public ResponseEntity<BankResponseDto> createBank(@RequestBody BankRequestDto bankRequestDto){

        BankResponseDto bank = bankService.createBank(bankRequestDto);
        return new ResponseEntity<>(bank,HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<BankResponseDto> getBankById(@PathVariable("id") Long bankId){
        BankResponseDto bank = bankService.getBankById(bankId);
        return ResponseEntity.ok(bank);
    }
    @GetMapping
    public ResponseEntity<List<BankResponseDto>> getAllBanks(){
       List<BankResponseDto> bank = bankService.getAllBanks();
        return ResponseEntity.ok(bank);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BankResponseDto> updateBank(@RequestBody BankRequestDto bankRequestDto, @PathVariable Long id){
        BankResponseDto bank = bankService.updateBank(bankRequestDto,id);
        return ResponseEntity.ok(bank);
    }
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteBank(@PathVariable Long id){
        bankService.deleteBank(id);
        return  ResponseEntity.noContent().build();
    }
}
