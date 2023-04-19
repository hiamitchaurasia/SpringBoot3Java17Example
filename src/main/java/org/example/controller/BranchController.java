package org.example.controller;

import org.example.domain.entity.Branch;
import org.example.service.BranchService;
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
