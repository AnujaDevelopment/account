package com.demo.account.service;

import com.demo.account.entity.AccountTransaction;
import com.demo.account.entity.Accounts;
import com.demo.account.model.response.AccountDetailsResponseDto;
import com.demo.account.model.response.AccountTransactionDetailsResponseDto;
import com.demo.account.repository.AccountRepository;
import com.demo.account.repository.AccountTransactionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {

    @InjectMocks
    private AccountService service;

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private AccountTransactionRepository accountTransactionRepository;

    @Test
    public void getAccountDetailsTest(){
        List<Accounts> acclist = getAccountDetailsList();
        Mockito.when(accountRepository.findAll()).thenReturn(acclist);
        List<AccountDetailsResponseDto> list = service.getAccountDetails();
        Assertions.assertEquals(acclist.size(),list.size());
    }

    @Test
    public void getAccountTransactionDetailsTest(){
        List<AccountTransaction> acclist = getAccountTransactionDetailsList();
        Mockito.when(accountTransactionRepository.findByAccountNumber("123-2223-212")).thenReturn(acclist);
        List<AccountTransactionDetailsResponseDto> list = service.getAccountTransactionDetails("123-2223-212");
        Assertions.assertEquals(acclist.size(),list.size());
    }

    public List<Accounts> getAccountDetailsList() {
        List<Accounts> accountsList = new ArrayList<>();
        Accounts account1 = new Accounts();
        account1.setAccountNumber("585309209");
        account1.setAccountName("SGSavings726");
        account1.setAccountType("Savings");
        account1.setBalanceDate("08/11/2018");
        account1.setCurrency("SGD");
        account1.setOpenAvailableBalance("84,327.51");

        Accounts account2 = new Accounts();
        account2.setAccountNumber("91530920");
        account2.setAccountName("AUCurrent433");
        account2.setAccountType("Current");
        account2.setBalanceDate("08/11/2018");
        account2.setCurrency("AUD");
        account2.setOpenAvailableBalance("36,327.80");

        Accounts account3 = new Accounts();
        account3.setAccountNumber("791066619");
        account3.setAccountName("AUSavings933");
        account3.setAccountType("Savings");
        account3.setBalanceDate("08/11/2018");
        account3.setCurrency("AUD");
        account3.setOpenAvailableBalance("88,005.93");
        accountsList.addAll(Arrays.asList(account1, account2, account3));
        return accountsList;
    }

    public List<AccountTransaction> getAccountTransactionDetailsList() {
        List<AccountTransaction> accountTransactionList = new ArrayList<>();
        AccountTransaction accountTransaction1 = new AccountTransaction();
        accountTransaction1.setAccountNumber("123-2223-212");
        accountTransaction1.setAccountName("Current Account");
        accountTransaction1.setCreditAmount("9,540.98");
        accountTransaction1.setDebitAmount(null);
        accountTransaction1.setCurrency("SGD");
        accountTransaction1.setValueDate("Jan. 12,2012");
        accountTransaction1.setdeditCredit("Credit");
        accountTransaction1.setTransactionNarrative(null);

        AccountTransaction accountTransaction2 = new AccountTransaction();
        accountTransaction2.setAccountNumber("123-2223-212");
        accountTransaction2.setAccountName("Saving Account");
        accountTransaction2.setDebitAmount("8,540.70");
        accountTransaction2.setCreditAmount(null);
        accountTransaction2.setCurrency("SGD");
        accountTransaction2.setValueDate("Juln. 12,2012");
        accountTransaction2.setdeditCredit("Debit");
        accountTransaction2.setTransactionNarrative(null);

        accountTransactionList.addAll(Arrays.asList(accountTransaction1, accountTransaction2));
        return accountTransactionList;
    }
}
