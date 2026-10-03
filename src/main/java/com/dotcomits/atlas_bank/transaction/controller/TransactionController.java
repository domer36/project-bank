package com.dotcomits.atlas_bank.transaction.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dotcomits.atlas_bank.transaction.model.Transaction;
import com.dotcomits.atlas_bank.transaction.service.ITransactionQueryService;
import com.dotcomits.atlas_bank.transaction.service.ITransferService;

import lombok.RequiredArgsConstructor;

@RestController 
@RequestMapping ("/api/v1/transactions")
@RequiredArgsConstructor 
public class TransactionController {

    private final ITransferService transferService;
    private final ITransactionQueryService transactionQueryService;

    @PostMapping ("/transfer") 
    public ResponseEntity<Transaction> transfer(@RequestParam Long fromId, @RequestParam Long toId, @RequestParam BigDecimal amount) {
        return ResponseEntity.ok(transferService.execute(fromId, toId, amount));
    }

    @GetMapping ("/{accountId}/transactions")
    public ResponseEntity<List<Transaction>> getTransactionsForAccount(@PathVariable Long accountId) {
        List<Transaction> transactions = transactionQueryService.getByAccountId(accountId);
        return ResponseEntity.ok(transactions);
    }
}
