package com.current.bank.controller;

import com.current.bank.dto.AuthorizationRequest;
import com.current.bank.dto.LoadRequest;
import com.current.bank.dto.LoadResponse;
import com.current.bank.models.Transaction;
import com.current.bank.repository.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class TransactionController {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @PutMapping(path="/load/{messageId}", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LoadResponse> loadBalance(@PathVariable long messageId, @RequestBody LoadRequest loadRequest) {
        log.info("In loadBalance, loadRequest {}", loadRequest);
        List<Transaction> transactions = transactionRepository.findAll();
        Transaction transaction;
        if (transactions.isEmpty()) {
            transaction = new Transaction(loadRequest.getTransactionAmount());
            transactionRepository.saveAndFlush(transaction);
        } else {
            transaction = transactions.get(0);
            transaction.setAmountInCents(transaction.getAmountInCents() + loadRequest.getTransactionAmount());
            transactionRepository.saveAndFlush(transaction);
        }
        return ResponseEntity.ok(LoadResponse.builder().userId(loadRequest.getUserId()).balance(transaction.getAmountInCents()).build());
    }

    @PutMapping(path="/authorization/{messageId}", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LoadResponse> authorization(@PathVariable long messageId, @RequestBody AuthorizationRequest authorizationRequest) {
        log.info("In loadBalance, authorizationRequest {}", authorizationRequest);
        List<Transaction> transactions = transactionRepository.findAll();
        Transaction transaction;
        if (transactions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            transaction = transactions.get(0);
            transaction.setAmountInCents(transaction.getAmountInCents() - authorizationRequest.getTransactionAmount());
            transactionRepository.saveAndFlush(transaction);
        }
        return ResponseEntity.ok(LoadResponse.builder().balance(transaction.getAmountInCents()).userId(authorizationRequest.getUserId()).build());
    }
}