package com.semi.book.dto;

import com.semi.book.domain.Member;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MemberMapper {
    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);


    Member dtoToMember(MemberDTO memberDTO);

    MemberDTO memberToDto(Member member);

}
