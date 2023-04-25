package com.hiamitchaurasia.example1.service;

import com.hiamitchaurasia.example1.domain.entity.Branch;
import com.hiamitchaurasia.example1.domain.repository.BranchRepository;
import org.springframework.stereotype.Service;

@Service
public class BranchService {

    private final BranchRepository branchRepository;

    public BranchService(BranchRepository branchRepository) {

        this.branchRepository = branchRepository;
    }

    public Branch getBranch(Integer id) {
        return branchRepository.findBranchById(id);
    }
}
