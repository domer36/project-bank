package com.dotcomits.atlas_bank.service;

import java.math.BigDecimal;

import com.dotcomits.atlas_bank.model.Transaction;

public interface ITransferService {
    Transaction execute(Long fromId, Long toId, BigDecimal amount);
}
