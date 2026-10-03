package com.dotcomits.atlas_bank.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dotcomits.atlas_bank.model.Account;
import com.dotcomits.atlas_bank.model.Transaction;
import com.dotcomits.atlas_bank.service.IAccountService;
import com.dotcomits.atlas_bank.service.ITransactionQueryService;
import com.dotcomits.atlas_bank.service.ITransferService;

import lombok.RequiredArgsConstructor;

@RestController 
@RequestMapping ("/api/accounts")
@RequiredArgsConstructor 
public class AccountController {

    private final IAccountService accountService;
    private final ITransferService transferService;
    private final ITransactionQueryService transactionQueryService;

    @PostMapping 
    public ResponseEntity<Account> create(@RequestBody Account account) {
        Account createdAccount = accountService.create(account);
        return ResponseEntity.ok(createdAccount);
    }

    @GetMapping 
    public ResponseEntity<List<Account>> findAll() {
        List<Account> accounts = accountService.findAll();
        return ResponseEntity.ok(accounts);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Account> findById(@PathVariable Long id) {
        Account account = accountService.findById(id);
        return ResponseEntity.ok(account);
    }

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
