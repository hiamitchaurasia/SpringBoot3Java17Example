package org.example.controller;

import org.example.domain.entity.Account;
import org.example.service.AccountService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {

        this.accountService = accountService;
    }

    @GetMapping(path = "/accounts/{accountNumber}")
    public Account getAccount(@PathVariable("accountNumber") String accountNumber) {
        return accountService.getAccount(accountNumber);
    }

    @GetMapping(path = "/accounts")
    public List<Account> getAccounts(@RequestParam("branchCode") String branchCode) {
        return accountService.getAccounts(branchCode);
    }

    @GetMapping(path = "/allAccounts")
    public Page<Account> getAllAccounts(Pageable pageable) {
        Pageable pageableWithSortDirection = PageRequest.of(pageable.getPageNumber(), 1, Sort.by("balance").descending());
        Page<Account> largest15AccountsByBalance = accountService.findAllAccounts(pageableWithSortDirection);
        System.out.println(largest15AccountsByBalance);
        return  largest15AccountsByBalance;
    }

}
