package com.semi.book.repository;

import com.semi.book.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {
    Optional<Member> findByUserId(String userId);
    Optional<Member> findByNameAndEmail(String name, String email);
    Optional<Member> findByUserIdAndEmail(String userId, String email);

}
