package com.app.quickFund.controller;

import com.app.quickFund.dto.TransactionDto;
import com.app.quickFund.dto.TransferRequestDto;
import com.app.quickFund.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/transfer")
    public ResponseEntity<TransactionDto> transferMoney(@RequestBody TransferRequestDto requestDto){
        TransactionDto transaction = transactionService.transferMoney(requestDto);
        return new ResponseEntity<>(transaction,HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TransactionDto> getByTransaction(@PathVariable ("id") Long trasactionId){
        TransactionDto transaction = transactionService.getTransactionById(trasactionId);
        return ResponseEntity.ok().body(transaction);
    }
    @GetMapping
    public ResponseEntity<List<TransactionDto>> getAllTransactions(){
        List<TransactionDto> transactionList = transactionService.getAlltransactions();
        return ResponseEntity.ok().body(transactionList);
    }

}
