package com.dotcomits.atlas_bank.transaction.validation;

import com.dotcomits.atlas_bank.transaction.dto.TransactionRequest;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DifferentAccountsValidator implements ConstraintValidator<DifferentAccounts, TransactionRequest> {

    @Override
    public boolean isValid(TransactionRequest request, ConstraintValidatorContext context) {
        if (request.getSourceAccountId() == null || request.getTargetAccountId() == null) {
            return true;
        }

        return !request.getSourceAccountId().equals(request.getTargetAccountId());
    }

}
