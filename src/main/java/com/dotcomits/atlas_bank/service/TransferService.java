package com.dotcomits.atlas_bank.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dotcomits.atlas_bank.model.Account;
import com.dotcomits.atlas_bank.model.Transaction;
import com.dotcomits.atlas_bank.repository.AccountRepository;
import com.dotcomits.atlas_bank.repository.TransactionRepository;
import com.dotcomits.atlas_bank.service.fee.FeeCalculator;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class TransferService {
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;
    private final List<FeeCalculator> feeCalculators;

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

        BigDecimal fee = feeCalculators.stream()
            .filter(calculator -> calculator.supports(sourceAccount.getType()))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("No fee calculator found for transfer type: " + sourceAccount.getType()))
            .calculateFee(amount);

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
