package com.demo.account.controller;

import com.demo.account.model.response.AccountDetailsResponseDto;
import com.demo.account.model.response.AccountTransactionDetailsResponseDto;
import com.demo.account.service.AccountService;
import com.demo.account.util.InsertAccountDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private InsertAccountDetails insertAccountDetails;

    @PostConstruct
    public void init() {
        insertAccountDetails.saveAccountDetails();
        insertAccountDetails.saveAccountTransactionDetails();
    }

    @GetMapping(value = "/accounts")
    public List<AccountDetailsResponseDto> getAccounts() {
        return accountService.getAccountDetails();
    }

    @GetMapping(value = "/accounts/{accountNumber}")
    public List<AccountTransactionDetailsResponseDto> getAccountsTransaction(@PathVariable("accountNumber") String accountNumber) {
        return accountService.getAccountTransactionDetails(accountNumber);
    }
}
