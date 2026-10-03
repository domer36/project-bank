package com.dotcomits.atlas_bank.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dotcomits.atlas_bank.model.Account;
import com.dotcomits.atlas_bank.repository.AccountRepository;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class AccountService {
    private final AccountRepository accountRepository;

    public Account create(Account account) {
        return accountRepository.save(account);
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public Account findById(Long id) {
        return accountRepository.findById(id).orElseThrow(
            () -> new RuntimeException("Account not found with id: " + id)
        );
    }
}
