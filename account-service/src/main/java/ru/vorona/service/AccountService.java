package ru.vorona.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vorona.entity.Account;
import ru.vorona.excaption.AccountNotFoundException;
import ru.vorona.repository.AccountRepository;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account getAccountById (Long accountId){
        return accountRepository.findById(accountId)
                .orElseThrow(()->new AccountNotFoundException("Unable to find account with id: " + accountId));
    }

    public Long createAccount(String name, String email, String phone, List<Long>bills){
        Account account = new Account(name,email,phone, OffsetDateTime.now(),bills);
        return accountRepository.save(account).getAccountId();
    }

    public Account updateAccount (Long accountId,String name, String email, String phone, List<Long>bills) {
        Account account = new Account();
        account.setAccountId(accountId);
        account.setName(name);
        account.setEmail(email);
        account.setBills(bills);
        account.setPhone(phone);
//        account.setCreationTime(OffsetDateTime.now());
        return accountRepository.save(account);
    }

    public Account deleteAccount(Long accountId) {
        Account deleteAccount = getAccountById(accountId);
        accountRepository.deleteById(accountId);
        return deleteAccount;

    }

}
