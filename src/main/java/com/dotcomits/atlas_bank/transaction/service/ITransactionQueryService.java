package com.dotcomits.atlas_bank.transaction.service;

import java.util.List;

import com.dotcomits.atlas_bank.transaction.model.Transaction;

public interface ITransactionQueryService {
    List<Transaction> getByAccountId(Long accountId);
}
