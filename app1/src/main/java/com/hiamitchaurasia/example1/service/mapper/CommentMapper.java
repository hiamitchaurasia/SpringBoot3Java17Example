package com.hiamitchaurasia.example1.service.mapper;


import com.hiamitchaurasia.example1.domain.Comment;
import com.hiamitchaurasia.example1.service.dto.CommentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CommentMapper extends EntityMapper<CommentDTO, Comment> {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);
}
