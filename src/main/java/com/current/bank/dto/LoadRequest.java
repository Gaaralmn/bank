package com.current.bank.dto;

import lombok.Data;

@Data
public class LoadRequest {
    private long userId;
    private double transactionAmount;
}
