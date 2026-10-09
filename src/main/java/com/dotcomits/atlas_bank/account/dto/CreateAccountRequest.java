package com.dotcomits.atlas_bank.account.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data 
public class CreateAccountRequest {
    private String accountNumber;
    private String ownerName;
    private String email;
    private String type;
    private BigDecimal balance;
}
