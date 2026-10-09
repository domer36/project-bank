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

    @PostMapping 
    public ResponseEntity<AccountResponse> create(@RequestBody CreateAccountRequest request) {
        Account account = new Account();
        account.setAccountNumber(request.getAccountNumber());
        account.setOwnerName(request.getOwnerName());
        account.setEmail(request.getEmail());
        account.setType(request.getType());
        account.setBalance(request.getBalance());

        Account createdAccount = accountService.create(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(toResponse(createdAccount));
    }

    @GetMapping 
    public ResponseEntity<List<AccountResponse>> findAll() {
        List<AccountResponse> accountResponses = accountService.findAll()
            .stream()
            .map(this::toResponse)
            .toList();
        return ResponseEntity.status(HttpStatus.OK).body(accountResponses);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<AccountResponse> findById(@PathVariable Long id) {
        Account account = accountService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(toResponse(account));
    }

    private AccountResponse toResponse(Account account) {
        AccountResponse response = new AccountResponse();
        response.setId(account.getId());
        response.setAccountNumber(account.getAccountNumber());
        response.setOwnerName(account.getOwnerName());
        response.setEmail(account.getEmail());
        response.setType(account.getType());
        response.setBalance(account.getBalance());
        response.setStatus(account.getStatus());
        response.setCreatedAt(account.getCreatedAt());
        return response;
    }
}
