package com.hiamitchaurasia.example1.repository;

import com.hiamitchaurasia.example1.domain.Proposal;
import com.hiamitchaurasia.example1.domain.enumeration.ProposalState;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProposalRepository extends JpaRepository<Proposal, Long>, JpaSpecificationExecutor<Proposal> {

    Page<Proposal> findProposalsByState(Pageable pageable, ProposalState state);
}
