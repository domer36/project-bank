package com.dotcomits.atlas_bank.account.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dotcomits.atlas_bank.account.dto.AccountMapper;
import com.dotcomits.atlas_bank.account.dto.AccountResponse;
import com.dotcomits.atlas_bank.account.dto.CreateAccountRequest;
import com.dotcomits.atlas_bank.account.model.Account;
import com.dotcomits.atlas_bank.account.service.IAccountService;

import lombok.RequiredArgsConstructor;

@RestController 
@RequestMapping ("/api/v1/accounts")
@RequiredArgsConstructor 
public class AccountController {

    private final IAccountService accountService;
    private final AccountMapper accountMapper;

    @PostMapping 
    public ResponseEntity<AccountResponse> create(@RequestBody CreateAccountRequest request) {
        Account account = accountMapper.toEntity(request);

        Account createdAccount = accountService.create(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(accountMapper.toResponse(createdAccount));
    }

    @GetMapping 
    public ResponseEntity<List<AccountResponse>> findAll() {
        List<AccountResponse> accountResponses = accountService.findAll()
            .stream()
            .map(accountMapper::toResponse)
            .toList();
        return ResponseEntity.status(HttpStatus.OK).body(accountResponses);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<AccountResponse> findById(@PathVariable Long id) {
        Account account = accountService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(accountMapper.toResponse(account));
    }
}
