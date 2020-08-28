package com.current.bank.dto;

import lombok.Data;

@Data
public class AuthorizationRequest {
    private long userId;
    private double transactionAmount;
}
