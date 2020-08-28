package com.current.bank.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Transaction extends BaseModel {

    @Column(name = "amount_in_cents", nullable = false, columnDefinition="DECIMAL(20,8) default 0.0")
    private double amountInCents;

    public Transaction(double amountInCents) {
        this.amountInCents = amountInCents;
    }
}
