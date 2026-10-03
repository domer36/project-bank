package com.dotcomits.atlas_bank.account.service;

import java.util.List;

import com.dotcomits.atlas_bank.account.model.Account;

public interface IAccountService {
    Account create(Account account);

    List<Account> findAll();

    Account findById(Long id);
}
