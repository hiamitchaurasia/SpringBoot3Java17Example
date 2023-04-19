package org.example.service;

import org.example.domain.entity.Branch;
import org.example.domain.repository.BranchRepository;
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
