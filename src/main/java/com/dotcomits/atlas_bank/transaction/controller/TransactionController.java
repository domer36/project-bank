package com.dotcomits.atlas_bank.transaction.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dotcomits.atlas_bank.transaction.dto.TransactionMapper;
import com.dotcomits.atlas_bank.transaction.dto.TransactionRequest;
import com.dotcomits.atlas_bank.transaction.dto.TransactionResponse;
import com.dotcomits.atlas_bank.transaction.model.Transaction;
import com.dotcomits.atlas_bank.transaction.service.ITransactionQueryService;
import com.dotcomits.atlas_bank.transaction.service.ITransferService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController 
@RequestMapping ("/api/v1/transactions")
@RequiredArgsConstructor 
public class TransactionController {

    private final ITransferService transferService;
    private final ITransactionQueryService transactionQueryService;
    private final TransactionMapper transactionMapper;

    @PostMapping ("/transfer") 
    public ResponseEntity<TransactionResponse> transfer(@Valid @RequestBody TransactionRequest request) {
        Transaction transaction = transferService.execute(
            request.getSourceAccountId(),
            request.getTargetAccountId(),
            request.getAmount()
        );
        return ResponseEntity.ok(transactionMapper.toResponse(transaction));
    }

    @GetMapping ("/{accountId}/transactions")
    public ResponseEntity<List<TransactionResponse>> getTransactionsForAccount(@PathVariable Long accountId) {
        List<TransactionResponse> transactions = transactionQueryService.getByAccountId(accountId)
            .stream()
            .map(transactionMapper::toResponse)
            .toList();
        return ResponseEntity.ok(transactions);
    }
}
