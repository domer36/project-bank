package com.dotcomits.atlas_bank.account.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.dotcomits.atlas_bank.account.model.Account;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Account toEntity(CreateAccountRequest request);
    
    AccountResponse toResponse(Account account);
}
