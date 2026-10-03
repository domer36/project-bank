package com.dotcomits.atlas_bank.transaction.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dotcomits.atlas_bank.transaction.model.Transaction;
import com.dotcomits.atlas_bank.transaction.repository.TransactionRepository;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class TransactionQueryService implements ITransactionQueryService {
    private final TransactionRepository transactionRepository;

    @Override
    public List<Transaction> getByAccountId(Long accountId) {
        return transactionRepository.findBySourceAccountIdOrTargetAccountId(accountId, accountId);
    }
}
