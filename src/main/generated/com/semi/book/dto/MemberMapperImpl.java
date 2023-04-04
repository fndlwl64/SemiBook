package com.semi.book.dto;

import com.semi.book.domain.Gender;
import com.semi.book.domain.Grade;
import com.semi.book.domain.Member;
import com.semi.book.domain.Member.MemberBuilder;
import com.semi.book.domain.State;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-04T17:33:20+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.15.1 (Oracle Corporation)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public Member dtoToMember(MemberDTO memberDTO) {
        if ( memberDTO == null ) {
            return null;
        }

        MemberBuilder member = Member.builder();

        member.id( memberDTO.getId() );
        member.name( memberDTO.getName() );
        if ( memberDTO.getGender() != null ) {
            member.gender( Enum.valueOf( Gender.class, memberDTO.getGender() ) );
        }
        member.userId( memberDTO.getUserId() );
        member.password( memberDTO.getPassword() );
        member.phone( memberDTO.getPhone() );
        member.address( memberDTO.getAddress() );
        member.email( memberDTO.getEmail() );
        if ( memberDTO.getCreateDate() != null ) {
            member.createDate( LocalDateTime.parse( memberDTO.getCreateDate() ) );
        }
        if ( memberDTO.getGrade() != null ) {
            member.grade( Enum.valueOf( Grade.class, memberDTO.getGrade() ) );
        }
        if ( memberDTO.getState() != null ) {
            member.state( Enum.valueOf( State.class, memberDTO.getState() ) );
        }
        List<String> list = memberDTO.getRoles();
        if ( list != null ) {
            member.roles( new ArrayList<String>( list ) );
        }

        return member.build();
    }

    @Override
    public MemberDTO memberToDto(Member member) {
        if ( member == null ) {
            return null;
        }

        MemberDTO memberDTO = new MemberDTO();

        memberDTO.setId( member.getId() );
        memberDTO.setName( member.getName() );
        if ( member.getGender() != null ) {
            memberDTO.setGender( member.getGender().name() );
        }
        memberDTO.setUserId( member.getUserId() );
        memberDTO.setPassword( member.getPassword() );
        memberDTO.setPhone( member.getPhone() );
        memberDTO.setAddress( member.getAddress() );
        memberDTO.setEmail( member.getEmail() );
        if ( member.getCreateDate() != null ) {
            memberDTO.setCreateDate( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( member.getCreateDate() ) );
        }
        if ( member.getGrade() != null ) {
            memberDTO.setGrade( member.getGrade().name() );
        }
        if ( member.getState() != null ) {
            memberDTO.setState( member.getState().name() );
        }
        List<String> list = member.getRoles();
        if ( list != null ) {
            memberDTO.setRoles( new ArrayList<String>( list ) );
        }

        return memberDTO;
    }
}
