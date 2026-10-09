package com.dotcomits.atlas_bank.account.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data 
public class AccountResponse {
    private Long id;
    private String accountNumber;
    private String ownerName;
    private String email;
    private String type;
    private BigDecimal balance;
    private String status;
    private LocalDateTime createdAt;
}
