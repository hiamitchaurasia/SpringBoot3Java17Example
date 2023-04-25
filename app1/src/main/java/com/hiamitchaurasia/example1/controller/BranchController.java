package com.hiamitchaurasia.example1.controller;

import com.hiamitchaurasia.example1.domain.entity.Branch;
import com.hiamitchaurasia.example1.service.BranchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BranchController {

    private final BranchService branchService;

    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    @GetMapping(path = "/branches/{id}")
    public Branch getBranch(@PathVariable("id") Integer id) {
        return branchService.getBranch(id);
    }
}
