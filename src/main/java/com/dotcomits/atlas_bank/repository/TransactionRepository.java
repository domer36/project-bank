package com.dotcomits.atlas_bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dotcomits.atlas_bank.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
   List<Transaction> findBySourceAccountIdOrTargetAccountId(Long sourceAccountId, Long targetAccountId);
}
