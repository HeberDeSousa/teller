package org.example.model;

/*
* Scenario:
You are asked to implement a small Java program that processes a list of Payment objects. Each payment has:
- `id` (String)
- `amount` (double)
- `currency` (String)
- `status` (enum: `PENDING`, `SUCCESS`, `FAILED`)

Requirements:
1. Create the `Payment` class with proper encapsulation and `toString()`.
* */

import java.math.BigDecimal;

public class Payment {

    private String id;
    private BigDecimal amount;
    private String currency;
    private StatusEnum status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", status=" + status +
                '}';
    }
}
