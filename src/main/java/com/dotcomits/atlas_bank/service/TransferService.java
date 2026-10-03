package com.dotcomits.atlas_bank.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dotcomits.atlas_bank.model.Account;
import com.dotcomits.atlas_bank.model.Transaction;
import com.dotcomits.atlas_bank.repository.AccountRepository;
import com.dotcomits.atlas_bank.repository.TransactionRepository;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class TransferService {
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    @Transactional 
    public Transaction excecute(Long fromId, Long toId, BigDecimal amount) {
        Account sourceAccount = accountRepository.findById(fromId)
            .orElseThrow(() -> new RuntimeException("Source account not found with id: " + fromId));
        Account targetAccount = accountRepository.findById(toId)
            .orElseThrow(() -> new RuntimeException("Target account not found with id: " + toId));

        if (!"ACTIVE".equals(sourceAccount.getStatus())) {
            throw new RuntimeException("Source account is not active");
        }
        if (!"ACTIVE".equals(targetAccount.getStatus())) {
            throw new RuntimeException("Target account is not active");
        }

        if (sourceAccount.getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("Insufficient balance in source account");
        }

        BigDecimal fee;

        if ("SAVINGS".equals(sourceAccount.getType())) {
            fee = amount.multiply(new BigDecimal("0.01"));
        } else if ("CHECKING".equals(sourceAccount.getType())) {
            fee = amount.multiply(new BigDecimal("0.015")); 
        } else {
            fee = BigDecimal.ZERO;
        }

        sourceAccount.setBalance(sourceAccount.getBalance().subtract(amount).subtract(fee));
        targetAccount.setBalance(targetAccount.getBalance().add(amount));

        accountRepository.save(sourceAccount);
        accountRepository.save(targetAccount);

        Transaction transaction = new Transaction();
        transaction.setType("TRANSFER");
        transaction.setSourceAccountId(fromId);
        transaction.setTargetAccountId(toId);
        transaction.setAmount(amount);
        transaction.setFee(fee);
        transaction.setStatus("COMPLETED");
        return transactionRepository.save(transaction);
    }

}
