package com.current.bank.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoadResponse {
    private long userId;
    private double balance;
}