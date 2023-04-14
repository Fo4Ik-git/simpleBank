package com.jaga.entity;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String currency;
    private double balance;
    private List<Transaction> transactions;

    private Account() {
    }

    public Account(String currency, double balance) {
        this.currency = currency;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
