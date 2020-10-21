package com.demo.account.service;

import com.demo.account.entity.AccountTransaction;
import com.demo.account.entity.Accounts;
import com.demo.account.model.response.AccountDetailsResponseDto;
import com.demo.account.model.response.AccountTransactionDetailsResponseDto;
import com.demo.account.repository.AccountRepository;
import com.demo.account.repository.AccountTransactionRepository;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountTransactionRepository accountTransactionRepository;

    public List<AccountDetailsResponseDto> getAccountDetails() {
        final List<Accounts> accountsList = new ArrayList<>();
        final List<AccountDetailsResponseDto> accountDetailsResponseDtos = new ArrayList<>();
        try {
            accountRepository.findAll().forEach(account -> accountsList.add(account));
            accountsList.stream().forEach( account -> {
                AccountDetailsResponseDto accountDetailsResponseDto = new AccountDetailsResponseDto();
                accountDetailsResponseDto.setAccountName(account.getAccountName());
                accountDetailsResponseDto.setAccountNumber(account.getAccountNumber());
                accountDetailsResponseDto.setAccountType(account.getAccountType());
                accountDetailsResponseDto.setBalanceDate(account.getBalanceDate());
                accountDetailsResponseDto.setCurrency(account.getCurrency());
                accountDetailsResponseDto.setOpenAvailableBalance(account.getOpenAvailableBalance());
                accountDetailsResponseDtos.add(accountDetailsResponseDto);
            });
        }
        catch(Exception ex) {
            logger.error("Exception occured : {}", ex.getCause());
        }
        return accountDetailsResponseDtos;
    }

    public List<AccountTransactionDetailsResponseDto> getAccountTransactionDetails(String accountNumber) {
        final List<AccountTransaction> accountTransactionList = new ArrayList<>();
        final List<AccountTransactionDetailsResponseDto> accountTransactionDetailsResponseDtos = new ArrayList<>();
        try {
            accountTransactionRepository.findByAccountNumber(accountNumber).forEach(account -> accountTransactionList.add(account));
            accountTransactionList.stream().forEach( account -> {
                AccountTransactionDetailsResponseDto accountTransactionDetailsResponseDto = new AccountTransactionDetailsResponseDto();
                accountTransactionDetailsResponseDto.setAccountName(account.getAccountName());
                accountTransactionDetailsResponseDto.setAccountNumber(account.getAccountNumber());
                if(StringUtils.isNotEmpty(account.getCreditAmount())){
                    accountTransactionDetailsResponseDto.setCreditAmount(account.getCreditAmount());
                } else {
                    accountTransactionDetailsResponseDto.setCreditAmount("");
                }
                accountTransactionDetailsResponseDto.setCurrency(account.getCurrency());
                accountTransactionDetailsResponseDto.setDeditCredit(account.getdeditCredit());
                accountTransactionDetailsResponseDto.setValueDate(account.getValueDate());
                if(StringUtils.isNotEmpty(account.getDebitAmount())){
                    accountTransactionDetailsResponseDto.setDebitAmount(account.getDebitAmount());
                } else {
                    accountTransactionDetailsResponseDto.setDebitAmount("");
                }
                if(StringUtils.isNotEmpty(account.getTransactionNarrative())){
                    accountTransactionDetailsResponseDto.setTransactionNarrative(account.getTransactionNarrative());
                } else {
                    accountTransactionDetailsResponseDto.setTransactionNarrative("");
                }
                accountTransactionDetailsResponseDtos.add(accountTransactionDetailsResponseDto);

            });
        }
        catch(Exception ex) {
            logger.error("Exception occured during viewing account transaction : {}", ex.getCause());
        }
        return accountTransactionDetailsResponseDtos;
    }
}
