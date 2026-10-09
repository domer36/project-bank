package com.dotcomits.atlas_bank.transaction.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dotcomits.atlas_bank.transaction.dto.TransactionRequest;
import com.dotcomits.atlas_bank.transaction.dto.TransactionResponse;
import com.dotcomits.atlas_bank.transaction.model.Transaction;
import com.dotcomits.atlas_bank.transaction.service.ITransactionQueryService;
import com.dotcomits.atlas_bank.transaction.service.ITransferService;

import lombok.RequiredArgsConstructor;

@RestController 
@RequestMapping ("/api/v1/transactions")
@RequiredArgsConstructor 
public class TransactionController {

    private final ITransferService transferService;
    private final ITransactionQueryService transactionQueryService;

    @PostMapping ("/transfer") 
    public ResponseEntity<TransactionResponse> transfer(@RequestBody TransactionRequest request) {
        Transaction transaction = transferService.execute(
            request.getSourceAccountId(),
            request.getTargetAccountId(),
            request.getAmount()
        );
        return ResponseEntity.ok(toResponse(transaction));
    }

    @GetMapping ("/{accountId}/transactions")
    public ResponseEntity<List<TransactionResponse>> getTransactionsForAccount(@PathVariable Long accountId) {
        List<TransactionResponse> transactions = transactionQueryService.getByAccountId(accountId)
            .stream()
            .map(this::toResponse)
            .toList();
        return ResponseEntity.ok(transactions);
    }

    private TransactionResponse toResponse(Transaction transaction) {
        TransactionResponse response = new TransactionResponse();
        response.setId(transaction.getId());
        response.setType(transaction.getType());
        response.setSourceAccountId(transaction.getSourceAccountId());
        response.setTargetAccountId(transaction.getTargetAccountId());
        response.setAmount(transaction.getAmount());
        response.setFee(transaction.getFee());
        response.setStatus(transaction.getStatus());
        response.setCreateAt(transaction.getCreateAt());
        return response;
    }
}
