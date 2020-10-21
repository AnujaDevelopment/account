package com.demo.account.entity;

import javax.persistence.*;

@Entity
@Table(name = "Accounts")

public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String accountNumber;
    private String accountName;
    private String accountType;
    private String balanceDate;
    private String currency;
    private String openAvailableBalance;

    public Accounts(String accountNumber, String accountName, String accountType, String balanceDate, String currency, String openAvailableBalance) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.accountType = accountType;
        this.balanceDate = balanceDate;
        this.currency = currency;
        this.openAvailableBalance = openAvailableBalance;
    }

    public Accounts() {
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setBalanceDate(String balanceDate) {
        this.balanceDate = balanceDate;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setOpenAvailableBalance(String openAvailableBalance) {
        this.openAvailableBalance = openAvailableBalance;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getBalanceDate() {
        return balanceDate;
    }

    public String getCurrency() {
        return currency;
    }

    public String getOpenAvailableBalance() {
        return openAvailableBalance;
    }
}
