package com.dotcomits.atlas_bank.transaction.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data 
public class TransactionRequest {
    private Long sourceAccountId;
    private Long targetAccountId;
    private BigDecimal amount;
}
