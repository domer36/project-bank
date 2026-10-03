package com.dotcomits.atlas_bank.service.fee;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component 
public class DefaultFeeCalculator implements FeeCalculator {
    @Override
    public boolean supports(String transactionType) {
        return true;
    }

    @Override
    public BigDecimal calculateFee(BigDecimal amount) {
        return BigDecimal.ZERO; 
    }

}
