package com.dotcomits.atlas_bank.service.fee;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component 
public class SavingsFeeCalculator implements FeeCalculator {
    @Override
    public boolean supports(String transactionType) {
        return "SAVINGS".equalsIgnoreCase(transactionType);
    }

    @Override
    public BigDecimal calculateFee(BigDecimal amount) {
        return amount.multiply(new BigDecimal("0.01"));
    }

}
