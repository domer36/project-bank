package com.dotcomits.atlas_bank.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dotcomits.atlas_bank.model.Account;
import com.dotcomits.atlas_bank.service.AccountService;

import lombok.RequiredArgsConstructor;

@RestController 
@RequestMapping ("/api/accounts")
@RequiredArgsConstructor 
public class AccountController {

    private final AccountService accountService;

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
}
