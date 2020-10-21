package com.demo.account.entity;

import javax.persistence.*;

@Entity
@Table(name = "AccountTransaction")
public class AccountTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String accountNumber;
    private String accountName;
    private String valueDate;
    private String currency;
    private String debitAmount;
    private String creditAmount;
    private String deditCredit;
    private String transactionNarrative;

    public AccountTransaction(String accountNumber, String accountName, String valueDate, String currency, String debitAmount, String creditAmount, String beditCredit, String transactionNarrative) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.valueDate = valueDate;
        this.currency = currency;
        this.debitAmount = debitAmount;
        this.creditAmount = creditAmount;
        this.deditCredit = beditCredit;
        this.transactionNarrative = transactionNarrative;
    }

    public AccountTransaction() {
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getValueDate() {
        return valueDate;
    }

    public String getCurrency() {
        return currency;
    }

    public String getDebitAmount() {
        return debitAmount;
    }

    public String getCreditAmount() {
        return creditAmount;
    }

    public String getdeditCredit() {
        return deditCredit;
    }

    public String getTransactionNarrative() {
        return transactionNarrative;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setValueDate(String valueDate) {
        this.valueDate = valueDate;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setDebitAmount(String debitAmount) {
        this.debitAmount = debitAmount;
    }

    public void setCreditAmount(String creditAmount) {
        this.creditAmount = creditAmount;
    }

    public void setdeditCredit(String beditCredit) {
        this.deditCredit = beditCredit;
    }

    public void setTransactionNarrative(String transactionNarrative) {
        this.transactionNarrative = transactionNarrative;
    }
}
