package com.dotcomits.atlas_bank.account.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dotcomits.atlas_bank.account.model.Account;
import com.dotcomits.atlas_bank.account.repository.AccountRepository;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class AccountService implements IAccountService {
    private final AccountRepository accountRepository;

    @Override 
    public Account create(Account account) {
        return accountRepository.save(account);
    }

    @Override 
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override 
    public Account findById(Long id) {
        return accountRepository.findById(id).orElseThrow(
            () -> new RuntimeException("Account not found with id: " + id)
        );
    }

}
