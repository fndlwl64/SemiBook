package com.semi.book.api;

import com.semi.book.domain.Member;
import com.semi.book.dto.MemberDTO;
import com.semi.book.dto.MemberMapper;
import com.semi.book.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class MemberApiController {
    private final MemberRepository memberRepository;
    @PostMapping("/get/member")
    public MemberDTO getMember(@RequestBody MemberDTO memberDTO){
        System.out.println("memberDTO.toString() = " + memberDTO.toString());
        return memberDTO;
    }
    @GetMapping("/get/member/list")
    public List<Member> getMemberContent(){
        return memberRepository.findAll();
    }

    @PostMapping("/post/member")
    public MemberDTO postMember(@RequestBody MemberDTO memberDTO){
        System.out.println("=================================");
        System.out.println("POST MEMBER JOIN");
        System.out.println("memberDTO.toString() = " + memberDTO.toString());
        return memberDTO;
    }
}
