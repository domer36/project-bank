package com.dotcomits.atlas_bank.transaction.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data 
public class TransactionResponse {
    private Long id;
    private String type;
    private Long sourceAccountId;
    private Long targetAccountId;
    private BigDecimal amount;
    private BigDecimal fee;
    private String status;
    private LocalDateTime createAt;
}
