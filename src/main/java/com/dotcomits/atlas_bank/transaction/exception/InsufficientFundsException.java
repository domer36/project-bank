package com.dotcomits.atlas_bank.transaction.exception;

import java.math.BigDecimal;

public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(Long accountId, BigDecimal balance, BigDecimal amount) {
        super("Insufficient funds in account with ID: " + accountId + ", balance: " + balance + ", attempted withdrawal amount: " + amount);
    }

}
