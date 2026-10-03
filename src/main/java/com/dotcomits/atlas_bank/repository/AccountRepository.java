package com.dotcomits.atlas_bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dotcomits.atlas_bank.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
