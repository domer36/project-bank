package com.dotcomits.atlas_bank.transaction.dto;

import org.mapstruct.Mapper;

import com.dotcomits.atlas_bank.transaction.model.Transaction;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    TransactionResponse toResponse(Transaction transaction);
}
