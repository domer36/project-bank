package com.dotcomits.atlas_bank.transaction.service.fee;

import java.math.BigDecimal;

public interface FeeCalculator {
    boolean supports(String transactionType);
    BigDecimal calculateFee(BigDecimal amount);
}
