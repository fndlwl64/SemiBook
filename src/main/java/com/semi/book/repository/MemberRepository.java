package com.semi.book.repository;

import com.semi.book.domain.Member;
import com.semi.book.dto.MemberDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface MemberRepository extends JpaRepository<Member,Long> {

    Optional<Member> findByUserId(String userId);
    Optional<MemberDTO.MemberUserId> findByNameAndEmail(String name, String email);
    Optional<MemberDTO.MemberPassword> findByUserIdAndEmail(String userId, String email);
}

