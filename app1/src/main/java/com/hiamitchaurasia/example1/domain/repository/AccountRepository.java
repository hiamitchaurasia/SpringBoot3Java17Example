package com.hiamitchaurasia.example1.domain.repository;

import com.hiamitchaurasia.example1.domain.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Query("select a from Account a join a.branch b where b.branchCode = ?1")
    public List<Account> findAccountsByBranchCode(String branchCode);

    @Query("select a from Account a join fetch a.branch where a.accountNumber = ?1")
    public Account findAccount(String accountNumber);

    @Query("select a from Account a")
    Page<Account> findAllAccounts(Pageable pageable);

}
