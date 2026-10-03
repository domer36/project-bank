package com.dotcomits.atlas_bank.service.fee;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component 
public class CheckingFeeCalculator implements FeeCalculator {
    @Override
    public boolean supports(String transactionType) {
        return "CHECKING".equalsIgnoreCase(transactionType);
    }

    @Override
    public BigDecimal calculateFee(BigDecimal amount) {
        return amount.multiply(new BigDecimal("0.015"));
    }

}
