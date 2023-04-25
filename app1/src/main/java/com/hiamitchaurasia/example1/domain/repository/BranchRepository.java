package com.hiamitchaurasia.example1.domain.repository;

import com.hiamitchaurasia.example1.domain.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Integer> {

    Branch findBranchById(Integer id);

}
