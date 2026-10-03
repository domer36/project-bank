package com.dotcomits.atlas_bank.service;

import java.util.List;

import com.dotcomits.atlas_bank.model.Transaction;

public interface ITransactionQueryService {
    List<Transaction> getByAccountId(Long accountId);
}
