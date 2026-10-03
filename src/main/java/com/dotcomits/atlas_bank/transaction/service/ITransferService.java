package com.dotcomits.atlas_bank.transaction.service;

import java.math.BigDecimal;

import com.dotcomits.atlas_bank.transaction.model.Transaction;

public interface ITransferService {
    Transaction execute(Long fromId, Long toId, BigDecimal amount);
}
