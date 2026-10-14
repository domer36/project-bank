package com.dotcomits.atlas_bank.transaction.dto;

import java.math.BigDecimal;

import com.dotcomits.atlas_bank.transaction.validation.DifferentAccounts;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data 
@DifferentAccounts
public class TransactionRequest {
    @NotNull(message = "Source account ID is required")
    private Long sourceAccountId;

    @NotNull(message = "Target account ID is required")
    private Long targetAccountId;

    @NotNull(message = "Amount is required")
    @Positive(message = "Amount must be zero or positive")
    private BigDecimal amount;
}
