package org.example.service;

import org.example.domain.entity.Account;
import org.example.domain.entity.Branch;
import org.example.domain.repository.AccountRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository){

        this.accountRepository = accountRepository;
    }
    public Account getAccount(String accountNumber){
        return  accountRepository.findAccount(accountNumber);
    }

    public List<Account> getAccounts(String branchCode){
        return  accountRepository.findAccountsByBranchCode(branchCode);
    }

    public Page<Account> findAllAccounts(Pageable pageableWithSortDirection) {
        List<Account> accountList = new ArrayList<>();
        Account account = new Account();
        Branch branch = new Branch();
        branch.setBranchCode("BranchCode1");
        branch.setBranchName("BranchName1");
        account.setAccountNumber("1234");
        account.setBalance(new BigDecimal(123));
        account.setBranch(branch);
        account.setFullName("Amit");
        account.setId(11);
        accountList.add(account);
        account = new Account();
        branch = new Branch();
        branch.setBranchCode("BranchCode2");
        branch.setBranchName("BranchName2");
        account.setAccountNumber("12345");
        account.setBalance(new BigDecimal(1234));
        account.setBranch(branch);
        account.setFullName("Amit1");
        account.setId(12);
        accountList.add(account);

        //Page<Account> pagedAccounts = new PageImpl<>(accountList);
        final int start = (int)pageableWithSortDirection.getOffset();
        final int end = Math.min((start + pageableWithSortDirection.getPageSize()), accountList.size());
        final Page<Account> pagedAccounts = new PageImpl<>(accountList.subList(start, end), pageableWithSortDirection, accountList.size());

        System.out.println("Start: " + start);
        System.out.println("End: " + end);

        return pagedAccounts;
        //return  accountRepository.findAllAccounts(pageableWithSortDirection);
    }
}
