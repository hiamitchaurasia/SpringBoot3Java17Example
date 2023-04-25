package com.hiamitchaurasia.example1.service.mapper;

import com.hiamitchaurasia.example1.domain.Proposal;
import com.hiamitchaurasia.example1.service.dto.ProposalDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProposalMapper extends EntityMapper<ProposalDTO, Proposal> {
    ProposalMapper INSTANCE = Mappers.getMapper(ProposalMapper.class);
}
