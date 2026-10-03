package com.dotcomits.atlas_bank.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dotcomits.atlas_bank.account.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
